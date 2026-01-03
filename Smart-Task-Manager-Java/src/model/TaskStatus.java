// File: src/model/TaskStatus.java
// Purpose: Defines the ONLY valid statuses a Task can have.
// Why enum?
// - Prevents invalid string values ("inprogress", "donee", etc.)
// - Improves readability and reduces bugs.

package model;

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE
}
