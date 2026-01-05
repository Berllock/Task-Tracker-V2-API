import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskService {

    List<TaskProperties> tasks;
    LocalDate today =  LocalDate.now();

    public void addTask(String description) {

        if (description == null || description.isEmpty()) {
            System.out.println("Description is null");
            return;
        }

        String id = UUID.randomUUID().toString();
        TaskProperties newTask = new TaskProperties(id, description, "todo", today, today);
        tasks.add(newTask);
        System.out.println("Task added");

    }

    public void updateTask(String id, String description) {
        if (description == null || description.isEmpty()) {
            System.out.println("Description is null");
        }

        TaskProperties taskUpdate = findTaskById(id);

        if (taskUpdate != null) {
            taskUpdate.setDescription(description);
            taskUpdate.setUpdatedAt(LocalDate.now());
            System.out.println("Task updated");
        } else {
            System.out.println("Task not found");
        }
    }

    public void deleteTask(String id) {
        TaskProperties task = findTaskById(id);

        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted");
        } else  {
            System.out.println("Task found");
        }
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

    public void listTasks() {
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
