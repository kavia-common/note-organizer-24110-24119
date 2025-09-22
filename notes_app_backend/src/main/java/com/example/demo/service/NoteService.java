package com.example.demo.service;

import com.example.notesappbackend.dto.NoteRequest;
import com.example.notesappbackend.dto.NoteResponse;
import com.example.demo.mapper.NoteMapper;
import com.example.notesappbackend.model.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Ocean Professional: Service layer for Notes CRUD operations.
 */
@Service
@Transactional
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public NoteResponse create(NoteRequest request) {
        Note saved = repository.save(NoteMapper.toEntity(request));
        return NoteMapper.toResponse(saved);
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public List<NoteResponse> list() {
        return repository.findAll().stream()
                .map(NoteMapper::toResponse)
                .toList();
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public NoteResponse get(Long id) {
        Note note = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
        return NoteMapper.toResponse(note);
    }

    // PUBLIC_INTERFACE
    public NoteResponse update(Long id, NoteRequest request) {
        Note note = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));
        NoteMapper.updateEntity(note, request);
        return NoteMapper.toResponse(repository.save(note));
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Note not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
