import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }

        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task with this ID already exist");
        }

        tasks.put(task.getTaskID(), task);
    }

    public void deleteTask(String taskID) {
        if (taskID == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        tasks.remove(taskID);
    }

    public void updateTaskName(String taskID, String name) {
        getTaskByID(taskID).setName(name);
    }

    public void updateTaskDescription(String taskID, String description) {
        getTaskByID(taskID).setDescription(description);
    }

    public Task getTaskByID(String taskID) {
        if (taskID == null) {
            throw new IllegalArgumentException("Task ID must not be null");
        }

        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        return tasks.get(taskID);
    }
}
