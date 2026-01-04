import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TaskService {

    List<TaskProperties> tasks;
    LocalDate today =  LocalDate.now();


    public void addTask(String description) {

        if (description == null) {
            System.out.println("Description is null");
            return;
        }

        String id = UUID.randomUUID().toString();
        TaskProperties newTask = new TaskProperties(id, description, "todo", today, today);
        tasks.add(newTask);
        System.out.println("Task added");

    }

    public void updateTask(String id, String description) {
        if (description == null) {
            System.out.println("Description is null");
        }

        String cleanId = id.trim();

        TaskProperties taskUpdate = findTaskById(cleanId);

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


    public TaskProperties findTaskById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        String cleanId = id.trim();

        return tasks.stream()
                .filter(Objects::nonNull)
                .filter(task -> task.getId() != null)
                .filter(task -> task.getId().equals(cleanId))
                .findFirst()
                .orElse(null);
    }




}
