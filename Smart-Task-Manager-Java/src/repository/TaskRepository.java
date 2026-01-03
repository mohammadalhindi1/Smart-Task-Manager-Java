// File: src/repository/TaskRepository.java
// Purpose:
// - Repository interface (contract) for data access.
// - It hides WHERE/HOW data is stored (memory, file, database, etc.).
//
// Why interface?
// - Allows switching implementations later (InMemory -> Database) without changing Service code.

package repository;

import java.util.List;
import java.util.Optional;

import model.Task;

public interface TaskRepository {
    // CREATE / UPSERT: store a task
    void save(Task task);

    // READ: get all tasks
    List<Task> findAll();

    // READ: get a task by ID
    // Optional = "may exist or may not" (safer than returning null)
    Optional<Task> findById(String id);

    // DELETE: remove by ID, returns true if something was removed
    boolean deleteById(String id);
}
