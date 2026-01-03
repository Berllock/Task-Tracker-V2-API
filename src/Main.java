//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskService task = new TaskService();

        if (args.length == 0) {
            printHelp();
        }






    }

    private static void printHelp() {
        System.out.println("""
                Add new task -> task-cli add "Your task"
                Update task -> update + ID + "Your task"
                Delete task -> delete + ID
                Mark a task as in progress -> mark-in-progress + ID
                Mark a task as done -> mark-done + ID
                List all tasks by status -> list done/ list todo/ list in-progress
                """);
    }

}