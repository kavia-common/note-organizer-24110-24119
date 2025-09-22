package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Ocean Professional: Request payload for creating/updating notes.
 */
public class NoteRequest {

    @Schema(description = "Title of the note", example = "Grocery List", maxLength = 240, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Size(max = 240)
    private String title;

    @Schema(description = "Content of the note (Markdown supported)", example = "- Milk\n- Eggs", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String content;

    public String getTitle() {
        return title;
    }

    public NoteRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NoteRequest setContent(String content) {
        this.content = content;
        return this;
    }
}
