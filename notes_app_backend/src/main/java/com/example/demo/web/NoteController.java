package com.example.notesappbackend.web;

import com.example.notesappbackend.dto.NoteRequest;
import com.example.notesappbackend.dto.NoteResponse;
import com.example.demo.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Ocean Professional: REST controller exposing CRUD endpoints for notes.
 */
@RestController
@RequestMapping("/api/notes")
@Tag(name = "Notes", description = "CRUD operations for notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    // PUBLIC_INTERFACE
    @Operation(
            summary = "Create a note",
            description = "Creates a new note with the provided title and content.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Note created",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error")
            }
    )
    @PostMapping
    public ResponseEntity<NoteResponse> create(@Valid @RequestBody NoteRequest request) {
        NoteResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUBLIC_INTERFACE
    @Operation(
            summary = "List notes",
            description = "Returns all notes ordered by default repository sorting.",
            responses = @ApiResponse(responseCode = "200", description = "Notes list")
    )
    @GetMapping
    public ResponseEntity<List<NoteResponse>> list() {
        return ResponseEntity.ok(service.list());
    }

    // PUBLIC_INTERFACE
    @Operation(
            summary = "Get note by ID",
            description = "Returns a single note by its identifier.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note found"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    // PUBLIC_INTERFACE
    @Operation(
            summary = "Update a note",
            description = "Updates title and content of an existing note.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note updated"),
                    @ApiResponse(responseCode = "404", description = "Note not found"),
                    @ApiResponse(responseCode = "400", description = "Validation error")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> update(@PathVariable Long id, @Valid @RequestBody NoteRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // PUBLIC_INTERFACE
    @Operation(
            summary = "Delete a note",
            description = "Deletes a note by its identifier.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Note deleted"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
