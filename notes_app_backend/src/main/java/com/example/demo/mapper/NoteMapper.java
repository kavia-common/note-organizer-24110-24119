package com.example.demo.mapper;

import com.example.demo.dto.NoteRequest;
import com.example.demo.dto.NoteResponse;
import com.example.demo.model.Note;

/**
 * Ocean Professional: Mapper between Note entity and DTOs.
 */
public final class NoteMapper {

    private NoteMapper() {}

    // PUBLIC_INTERFACE
    public static Note toEntity(NoteRequest request) {
        return new Note()
                .setTitle(request.getTitle())
                .setContent(request.getContent());
    }

    // PUBLIC_INTERFACE
    public static void updateEntity(Note entity, NoteRequest request) {
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
    }

    // PUBLIC_INTERFACE
    public static NoteResponse toResponse(Note entity) {
        return new NoteResponse()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setContent(entity.getContent())
                .setCreatedAt(entity.getCreatedAt())
                .setUpdatedAt(entity.getUpdatedAt());
    }
}
