package com.example.notesappbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

/**
 * Ocean Professional: Response payload representing a note.
 */
public class NoteResponse {

    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Title of the note", example = "Grocery List")
    private String title;

    @Schema(description = "Content of the note", example = "- Milk\n- Eggs")
    private String content;

    @Schema(description = "Creation timestamp (UTC)", example = "2024-10-01T12:34:56Z")
    private OffsetDateTime createdAt;

    @Schema(description = "Last update timestamp (UTC)", example = "2024-10-01T13:00:00Z")
    private OffsetDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public NoteResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NoteResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NoteResponse setContent(String content) {
        this.content = content;
        return this;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public NoteResponse setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public NoteResponse setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
