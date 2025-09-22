package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Ocean Professional: Spring Boot entry point for the Notes API service.
 */
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Notes API - Ocean Professional",
                version = "0.1.0",
                description = "REST API for creating, reading, updating, and deleting notes.",
                contact = @Contact(name = "Notes API Team")
        )
)
public class NotesAppBackendApplication {

    // PUBLIC_INTERFACE
    public static void main(String[] args) {
        SpringApplication.run(NotesAppBackendApplication.class, args);
    }
}
