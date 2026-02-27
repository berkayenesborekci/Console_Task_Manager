import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void addTask(String title) {
        Task task = new Task(nextId, title);
        tasks.add(task);
        nextId++;
        System.out.println("Task added: " + title);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {
        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found for this id.");
            return;
        }
        task.setCompleted(true);
        System.out.println("Task completed: " + task.getTitle());
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found for this id.");
            return;
        }
        tasks.remove(task);
        System.out.println("Task deleted: " + task.getTitle());
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}

