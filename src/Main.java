//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        if (args.length == 0) {
            printHelp();
        }

        TaskService task = new TaskService();
        String command = args[0].toLowerCase();

        try {
            switch (command) {
                case "add":
                    if (args.length < 2) {
                        System.err.println("Task need a description");
                    }
                    task.addTask(args[1]);
                    break;

                case "update":
                    if (args.length < 3) {
                        System.err.println("ID e new description are required");
                    }
                    task.updateTask(args[1], args[2]);
                    break;

                case "list":
                    task.listAllTasks();
                    break;

                case "list-done":
                    task.listTasksByStatus("done");
                    break;

                case "list-todo":
                    task.listTasksByStatus("todo");
                    break;

                case "list-inprogress":
                    task.listTasksByStatus("inprogress");
                    break;

                case "help":
                    printHelp();
                    break;

                case "delete":
                    if (args.length < 2) {
                        System.err.println("Task ID is required");
                        break;
                    }
                    task.deleteTask(args[1]);
                    break;

                default:
                    System.err.println("Unknown command");
                    printHelp();

            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
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