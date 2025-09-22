# note-organizer-24110-24119

## Notes Backend (notes_app_backend)

Ocean Professional – Spring Boot service providing RESTful CRUD for notes.

- Run locally:
  - ./gradlew bootRun
  - Swagger UI: http://localhost:8080/swagger-ui.html
  - Health: http://localhost:8080/health

- Environment variables (override defaults to connect to notes_app_database):
  - DB_URL (e.g., jdbc:postgresql://notes-db:5432/notes)
  - DB_DRIVER (e.g., org.postgresql.Driver)
  - DB_USERNAME
  - DB_PASSWORD
  - JPA_DIALECT (e.g., org.hibernate.dialect.PostgreSQLDialect)
  - JPA_DDL_AUTO (e.g., validate|update|none)
  - JPA_SHOW_SQL (true|false)
  - H2_CONSOLE_ENABLED (true|false)