package app;

import repository.InMemoryTaskRepository;
import service.TaskService;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService(new InMemoryTaskRepository());
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
