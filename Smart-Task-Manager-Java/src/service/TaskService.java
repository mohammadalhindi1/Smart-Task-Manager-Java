// File: src/service/TaskService.java
// Purpose:
// - Service layer = business logic + validation.
// - Controllers/UI (Main, later a Console Menu) should call this layer.
//
// Why Service layer?
// - Keeps rules in one place.
// - Makes testing easier.
// - Keeps Repository focused on data access only.

package service;

import java.util.List;

import model.Task;
import model.TaskStatus;
import repository.TaskRepository;

public class TaskService {
    private final TaskRepository repo;

    // Dependency Injection (DI):
    // We pass the repository into the service so we can swap implementations easily.
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public void create(Task task) {
        validateTitle(task.getTitle());
        repo.save(task);
    }

    // READ (all)
    public List<Task> getAll() {
        return repo.findAll();
    }

    // READ (by id) with a clear failure if missing
    public Task getByIdOrThrow(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: " + id));
    }

    // UPDATE (example: update status)
    public void updateStatus(String id, TaskStatus newStatus) {
        Task t = getByIdOrThrow(id);
        t.setStatus(newStatus);

        // In memory this isn't strictly necessary (same object reference),
        // but it keeps the pattern consistent for future DB repositories.
        repo.save(t);
    }

    // DELETE
    public boolean delete(String id) {
        return repo.deleteById(id);
    }

    // Validation example
    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
    }
}
