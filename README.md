# Smart Task Manager (Java)

A clean and extensible **task management system** built using **Core Java**.  
This project focuses on **Object-Oriented Programming (OOP)** fundamentals, basic **data structures**, and writing **maintainable, reusable code** suitable for backend-oriented systems.

---

## Project Overview

The application stores data in memory during runtime and does not persist data after exit.

The project is intentionally designed with a clear separation of responsibilities so it can be easily extended into a **Spring Boot application**, **REST API**, or integrated with a database in the future.

This is not a simple console exercise — it demonstrates real software engineering fundamentals.

---

## Features

- Command-based CLI interface
- Create, read, update, and delete (CRUD) tasks
- Task attributes:
  - Title
  - Description
  - Status: `TODO`, `IN_PROGRESS`, `DONE`
  - Priority: `LOW`, `MEDIUM`, `HIGH`
  - Deadline (days from now)
- Friendly error handling (invalid input does not crash the app)
- Clear separation between application layers

---

## Concepts Demonstrated

### Object-Oriented Programming (OOP)
- **Encapsulation** – private fields with controlled access
- **Abstraction** – repository interfaces decouple logic from storage
- **Polymorphism** – service layer works with repository contracts

### Data Structures
- `HashMap` for fast task lookup by ID
- `ArrayList` for task listing

### Software Design
- Separation of concerns (app / service / repository / model)
- Clean and readable code
- Architecture ready for future extensions

---

## 🗂️ Project Structure

```
src/
├── app/
│ ├── Main.java
│ └── ConsoleUI.java
├── model/
│ ├── Task.java
│ ├── TaskStatus.java
│ └── Priority.java
├── repository/
│ ├── TaskRepository.java
│ └── InMemoryTaskRepository.java
├── service/
│ └── TaskService.java
```

---

## ▶️ How to Run

### Requirements
- Java 17 or higher

### Compile & Run (Terminal)

```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

## Example Usage

After starting the application, the user interacts with the system using text-based commands:

- `add` to create a new task by providing title, description, priority, and deadline
- `list` to display all existing tasks
- `update` to change the status of a task using its ID
- `delete` to remove a task from the system
- `exit` to close the application

## Future Improvements

The following enhancements could be added to extend the project in the future:

- Persisting tasks to a file or database
- Adding unit tests using JUnit
- Exposing the functionality as a REST API using Spring Boot
- Introducing user authentication and role-based access
- Containerizing the application using Docker

## 👨‍💻 Author

**Mohammad Alhindi**  
Cloud Computing Graduate | Software Engineer  

- GitHub: https://github.com/mohammadalhindi  
- LinkedIn: https://www.linkedin.com/in/mohammad-alhendi13
