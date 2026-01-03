// File: src/repository/InMemoryTaskRepository.java
// Purpose:
// - In-memory repository implementation (stores data in RAM).
// - Great for learning and quick demos (no database needed).
//
// Data structure choice:
// - HashMap<id, Task> gives fast lookup by ID (average O(1)).

package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Task;

public class InMemoryTaskRepository implements TaskRepository {
    // storage holds tasks in memory. Key = task ID, Value = Task object.
    private final Map<String, Task> storage = new HashMap<>();

    @Override
    public void save(Task task) {
        // put() inserts or replaces the task under the same ID
        storage.put(task.getId(), task);
    }

    @Override
    public List<Task> findAll() {
        // Return a new list to avoid exposing internal storage collection directly.
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Task> findById(String id) {
        // ofNullable wraps null safely into Optional
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public boolean deleteById(String id) {
        // remove returns null if key did not exist
        return storage.remove(id) != null;
    }
}
