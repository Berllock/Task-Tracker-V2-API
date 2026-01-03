import java.time.LocalDate;
import java.util.List;
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




}
