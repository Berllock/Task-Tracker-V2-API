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

}