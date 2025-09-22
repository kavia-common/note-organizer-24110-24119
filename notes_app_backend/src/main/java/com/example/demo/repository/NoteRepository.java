package com.example.notesappbackend.repository;

import com.example.notesappbackend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ocean Professional: Repository for Note entity.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
