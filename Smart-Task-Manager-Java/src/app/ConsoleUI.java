// File: src/app/ConsoleUI.java
// Purpose: Command-based console interface (CLI).
// Notes:
// - Reads user commands and delegates work to TaskService.
// - Handles common input mistakes without crashing the program.

package app;

import java.time.LocalDateTime;
import java.util.Scanner;

import model.Priority;
import model.Task;
import model.TaskStatus;
import service.TaskService;

public class ConsoleUI {

    private final TaskService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(TaskService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("Smart Task Manager");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    handleAdd();
                    break;
                case "list":
                    handleList();
                    break;
                case "update":
                    handleUpdate();
                    break;
                case "delete":
                    handleDelete();
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Bye 👋");
                    return;
                default:
                    if (!command.isEmpty()) {
                        System.out.println("Unknown command. Type 'help'.");
                    }
            }
        }
    }

    private void handleAdd() {
        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Description: ");
            String description = scanner.nextLine();

            Priority priority = readPriority();

            int days = readNonNegativeInt("Deadline (days from now): ");
            LocalDateTime deadline = LocalDateTime.now().plusDays(days);

            Task task = new Task(title, description, priority, deadline);
            service.create(task);

            System.out.println("Task created.");
            System.out.println("Tip: use 'list' to see IDs (you can update/delete by full ID or last 6-8 chars).");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void handleList() {
    if (service.getAll().isEmpty()) {
        System.out.println("(no tasks)");
        return;
    }

    for (Task t : service.getAll()) {
        String fullId = t.getId();
        String shortId = fullId.substring(fullId.length() - 8);

        System.out.println(
                "[" + shortId + "] " +
                fullId + " | " +
                t.getTitle() + " | " +
                t.getStatus() + " | " +
                t.getPriority()
        );
    }

    System.out.println("Tip: you can use the short ID (in brackets) for update/delete.");
}

    private void handleUpdate() {
        try {
            if (service.getAll().isEmpty()) {
                System.out.println("(no tasks) — create one using 'add'");
                return;
            }

            System.out.print("Task ID (full or last 6-8 chars): ");
            String inputId = scanner.nextLine().trim();

            String id = resolveId(inputId);
            if (id == null) {
                System.out.println("Task not found. Tip: use 'list' and copy the ID (or last 6-8 chars).");
                return;
            }

            TaskStatus status = readStatus();

            service.updateStatus(id, status);
            System.out.println("Task updated.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Tip: status must be TODO / IN_PROGRESS / DONE");
        }
    }

    private void handleDelete() {
        if (service.getAll().isEmpty()) {
            System.out.println("(no tasks) — nothing to delete");
            return;
        }

        System.out.print("Task ID (full or last 6-8 chars): ");
        String inputId = scanner.nextLine().trim();

        String id = resolveId(inputId);
        if (id == null) {
            System.out.println("Task not found. Tip: use 'list' and copy the ID (or last 6-8 chars).");
            return;
        }

        boolean deleted = service.delete(id);
        System.out.println(deleted ? "Task deleted." : "Task not found.");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println(" add     - create new task");
        System.out.println(" list    - list all tasks");
        System.out.println(" update  - update task status");
        System.out.println(" delete  - delete task");
        System.out.println(" help    - show this help");
        System.out.println(" exit    - quit program");
    }

    // Reads a valid Priority from user input.
    private Priority readPriority() {
        while (true) {
            System.out.print("Priority (LOW/MEDIUM/HIGH): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Priority.valueOf(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid priority. Try: LOW, MEDIUM, HIGH");
            }
        }
    }

    // Reads a valid TaskStatus from user input.
    private TaskStatus readStatus() {
        while (true) {
            System.out.print("New status (TODO/IN_PROGRESS/DONE): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return TaskStatus.valueOf(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid status. Try: TODO, IN_PROGRESS, DONE");
            }
        }
    }

    // Reads an integer >= 0, prevents crashing on bad input.
    private int readNonNegativeInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int n = Integer.parseInt(input);
                if (n < 0) {
                    System.out.println("Please enter a non-negative number.");
                    continue;
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /*
     * resolveId
     * Accepts either:
     * - Full UUID, or
     * - Short ID: last 6-8 characters of UUID (convenience)
     *
     * Returns: full UUID if matched, otherwise null.
     */
    private String resolveId(String inputId) {
        if (inputId == null || inputId.isBlank()) {
            return null;
        }

        // Full match
        for (Task t : service.getAll()) {
            if (t.getId().equals(inputId)) {
                return t.getId();
            }
        }

        // Suffix match (short ID)
        for (Task t : service.getAll()) {
            if (t.getId().endsWith(inputId)) {
                return t.getId();
            }
        }

        return null;
    }
}