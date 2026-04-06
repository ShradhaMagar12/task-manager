import java.util.*;

class Task {
    String title;
    String assignedTo;
    String status;
    String priority;

    Task(String title, String assignedTo, String status, String priority) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.status = status;
        this.priority = priority;
    }
}

public class TaskManager {

    static List<Task> tasks = new ArrayList<>();

    // Create Task
    public static void createTask(String title, String assignedTo, String priority) {

        if (title == null || title.trim().isEmpty()) {
            System.out.println("❌ Error: Title cannot be empty");
            return;
        }

        Task task = new Task(title, assignedTo, "TO_DO", priority);
        tasks.add(task);

        System.out.println("Task Created: " + title);
    }

    // Change Status
    public static void updateStatus(String title, String newStatus) {

        List<String> validStatus = Arrays.asList("TO_DO", "IN_PROGRESS", "DONE");

        if (!validStatus.contains(newStatus)) {
            System.out.println("❌ Invalid Status!");
            return;
        }

        boolean found = false;

        for (Task t : tasks) {
            if (t.title.equalsIgnoreCase(title)) {
                t.status = newStatus;
                found = true;
                System.out.println("✅ Status Updated: " + title + " → " + newStatus);
            }
        }

        if (!found) {
            System.out.println("❌ Error: Task not found!");
        }
    }

    // Display Tasks
    public static void displayTasks() {
        for (Task t : tasks) {
            System.out.println(t.title + " | " + t.assignedTo + " | " + t.status + " | " + t.priority);
        }
    }

    // MAIN METHOD (IMPORTANT FOR OUTPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== TASK MANAGEMENT SYSTEM =====");

        // Create Task
        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        System.out.print("Assign To: ");
        String assignedTo = sc.nextLine();

        System.out.print("Enter Priority (LOW/MEDIUM/HIGH): ");
        String priority = sc.nextLine().toUpperCase();

        createTask(title, assignedTo, priority);

        // Update Status
        System.out.print("\nEnter Task to Update: ");
        String t = sc.nextLine();

        System.out.print("Enter New Status (TO_DO/IN_PROGRESS/DONE): ");
        String status = sc.nextLine().toUpperCase();

        updateStatus(t, status);

        // Display
        System.out.println("\nAll Tasks:");
        displayTasks();
    }
}