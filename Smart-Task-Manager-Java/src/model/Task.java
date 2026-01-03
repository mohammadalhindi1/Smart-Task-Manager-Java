// File: src/model/Task.java
// Purpose:
// - Domain model: represents a real "Task" in the system.
// - Think of it as a row in a database table (tasks).
//
// Key OOP notes:
// - Encapsulation: fields are private; access is controlled via getters/setters.
// - Immutability where it makes sense: id and createdAt are final (never change).

package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    // Unique identifier for the task (generated once).
    private final String id;

    private String title;
    private String description;

    // Using enums prevents invalid values.
    private TaskStatus status;
    private Priority priority;

    // Dates are represented with LocalDateTime (date + time, no timezone).
    private LocalDateTime deadline;

    // Created time is set once when the task is created.
    private final LocalDateTime createdAt;

    // Constructor initializes a valid Task object.
    public Task(String title, String description, Priority priority, LocalDateTime deadline) {
        // UUID = Universally Unique Identifier (almost guaranteed unique)
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;

        // Default status for a new task.
        this.status = TaskStatus.TODO;

        // Capture creation time.
        this.createdAt = LocalDateTime.now();
    }

    // ----- Getters (read-only access to private fields) -----
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public LocalDateTime getDeadline() { return deadline; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ----- Setters (controlled updates) -----
    // In real systems, you may validate here or in the Service layer.
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
    public void setStatus(TaskStatus status) { this.status = status; }
}
