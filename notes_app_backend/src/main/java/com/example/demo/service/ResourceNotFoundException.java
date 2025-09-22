package com.example.notesappbackend.service;

/**
 * Ocean Professional: Exception indicating a missing resource (HTTP 404).
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
