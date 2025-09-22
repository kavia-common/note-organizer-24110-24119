package com.example.notesappbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Ocean Professional: Minimal root endpoints to assist navigation and health.
 */
@RestController
@Tag(name = "System", description = "System endpoints for navigation and health checks")
public class HelloController {

    // PUBLIC_INTERFACE
    @GetMapping("/")
    @Operation(summary = "Welcome", description = "Returns a simple welcome message for the API.")
    public String hello() {
        return "Notes API (Ocean Professional): Welcome.";
    }

    // PUBLIC_INTERFACE
    @GetMapping("/docs")
    @Operation(summary = "OpenAPI Docs", description = "Redirects to Swagger UI for interactive API documentation.")
    public RedirectView docs() {
        return new RedirectView("/swagger-ui.html");
    }

    // PUBLIC_INTERFACE
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Quick application health status.")
    public String health() {
        return "OK";
    }

    // PUBLIC_INTERFACE
    @GetMapping("/api/info")
    @Operation(summary = "Application info", description = "Returns application information.")
    public String info() {
        return "Spring Boot Application: notesappbackend (Notes API)";
    }
}