import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleTaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean exit = false;

        System.out.println("Simple Task Manager");

        while (!exit) {
            System.out.println();
            System.out.println("1- Add task");
            System.out.println("2- List tasks");
            System.out.println("3- Complete task");
            System.out.println("4- Delete task");
            System.out.println("0- Exit");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task description: ");
                    String title = scanner.nextLine();
                    if (title.trim().isEmpty()) {
                        System.out.println("Task description cannot be empty.");
                    } else {
                        taskManager.addTask(title);
                    }
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.print("Task id to complete: ");
                    int completeId = readInt(scanner);
                    if (completeId != -1) {
                        taskManager.completeTask(completeId);
                    }
                    break;
                case 4:
                    System.out.print("Task id to delete: ");
                    int deleteId = readInt(scanner);
                    if (deleteId != -1) {
                        taskManager.deleteTask(deleteId);
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }
}

