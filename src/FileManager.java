import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void saveTasks(List<TaskProperties> tasks) {
        System.out.println("Saving tasks to file...");

        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("Failed to save tasks to file!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<TaskProperties> loadTasks() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Tasks file does not exist! Start new empty list");
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(FILE_NAME)){
            Type taskListType = new TypeToken<List<TaskProperties>>() {}.getType();

            List<TaskProperties> tasks = gson.fromJson(reader, taskListType);

            if (tasks == null) {
                System.out.println("Tasks file is empty! Empty file created");
                return new ArrayList<>();
            }

            System.out.println("Loaded tasks from file!");
            return tasks;

        } catch (IOException e) {
            System.err.println("Failed to load tasks from file!" + e.getMessage());
            return new ArrayList<>();
        }
    }



}