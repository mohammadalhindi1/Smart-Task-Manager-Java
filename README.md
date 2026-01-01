```
# Smart Task Manager (Java)

A clean and extensible **task management system** built using **Core Java**.  
This project focuses on **Object-Oriented Programming (OOP)** fundamentals, **data structures**, and writing **maintainable, reusable code** suitable for real-world backend systems.

---

## 🚀 Project Overview

Smart Task Manager allows users to create, manage, and track tasks with different priorities, statuses, and deadlines.  
The project is intentionally designed with a clean structure so it can be easily extended into a **Spring Boot application**, **REST API**, or integrated with a database in the future.

This is not a simple console exercise — it demonstrates real software engineering fundamentals.

---

## ✨ Features

- User-based task management
- Create, read, update, and delete (CRUD) tasks
- Task attributes:
  - Title & description
  - Status: `TODO`, `IN_PROGRESS`, `DONE`
  - Priority: `LOW`, `MEDIUM`, `HIGH`
  - Deadline
- Filter tasks by status or priority
- Clean separation between logic layers

---

## 🧠 Concepts Demonstrated

### Object-Oriented Programming (OOP)
- **Encapsulation** – private fields with controlled access
- **Inheritance** – shared behavior through base classes
- **Polymorphism** – interchangeable implementations via interfaces
- **Abstraction** – clear contracts between components

### Data Structures
- `ArrayList` for task collections
- `HashMap` for mapping users to tasks
- Designed to support:
  - `Queue` (task scheduling)
  - `Stack` (undo operations)

### Software Design
- Separation of concerns
- Clean, readable code
- Scalable architecture ready for future extensions
ذذذs
---

## 🗂️ Project Structure
```

src/
├── app/
│ └── Main.java
├── model/
│ ├── Task.java
│ ├── TaskStatus.java
│ └── Priority.java
├── repository/
│ ├── TaskRepository.java
│ └── InMemoryTaskRepository.java
├── service/
│ └── TaskService.java
└── utils/
└── Validator.java


---
## ▶️ How to Run

### Requirements
- Java 17 or higher

### Compile & Run (Terminal)
```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
Or simply run Main.java from your IDE.
```

🧪 Example Usage :
Start the application
Create tasks with priorities and deadlines
Update task status as work progresses
List or filter tasks
Delete completed or unnecessary tasks

📈 Future Improvements :
Add persistent storage (file or database)
Add unit tests using JUnit
Convert to Spring Boot REST API
Add authentication and user roles
Dockerize the application

👨‍💻 Author :
Mohammad Alhindi
Cloud Computing Graduate | Software Engineer
GitHub: https://github.com/mohammadalhindi1
LinkedIn: www.linkedin.com/in/mohammad-alhendi13
