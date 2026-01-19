import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TaskService {

    private final List<TaskProperties> tasks;
    private final FileManager fileManager;

    public TaskService() {
        this.fileManager = new FileManager();
        this.tasks = fileManager.loadTasks();
        System.out.println("Start Task Service with " + tasks.size() + " tasks");
    }

    public void addTask(String description) {

        if (description == null || description.isEmpty()) {
            System.out.println("Description is null");
            return;
        }

        String id = UUID.randomUUID().toString();

        TaskProperties newTask = new TaskProperties();
        newTask.setId(id);
        newTask.setDescription(description);
        newTask.setStatus("todo");
        newTask.setCreatedAt(LocalDate.now().toString());
        newTask.setUpdatedAt(LocalDate.now().toString());

        tasks.add(newTask);
        fileManager.saveTasks(tasks);

        System.out.println("Task added");

    }

    public void updateTask(String id, String description) {
        if (description == null || description.isEmpty()) {
            System.out.println("Description is null");
            return;
        }

        TaskProperties taskUpdate = findTaskById(id);

        if (taskUpdate != null) {
            taskUpdate.setDescription(description);
            taskUpdate.setUpdatedAt(LocalDate.now().toString());
            System.out.println("Task updated");
        } else {
            System.out.println("Task not found");
        }

        fileManager.saveTasks(tasks);
    }

    public void deleteTask(String id) {
        TaskProperties task = findTaskById(id);

        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted");
        } else  {
            System.out.println("Task not found");
        }

        fileManager.saveTasks(tasks);
    }

    public void listTasksByStatus(String status) {
        List<TaskProperties> filteredTask = tasks.stream()
                .filter(Objects::nonNull)
                .filter(task -> status != null && status.equalsIgnoreCase(task.getStatus()))
                .toList();

        if (filteredTask.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            filteredTask.forEach(System.out::println);
        }
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Not found tasks");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public TaskProperties findTaskById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        String cleanId = id.trim();

        return tasks.stream()
                .filter(Objects::nonNull)
                .filter(task -> task.getId() != null)
                .filter(task -> cleanId.equals(task.getId()))
                .findFirst()
                .orElse(null);
    }


}
