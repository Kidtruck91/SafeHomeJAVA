import java.util.Scanner;

public class SafeHomeSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy user for demonstration
        HomeUser user = new HomeUser();
        user.userID = "user123";
        user.name = "Alice";
        user.email = "alice@example.com";
        user.role = "HomeUser";

        System.out.println("Welcome to SafeHome, " + user.name + "!");
        System.out.println("Choose an action:");
        System.out.println("1. View Camera Feed");
        System.out.println("2. Set Alarm");
        System.out.println("3. Lock Door");
        System.out.println("4. Trigger Emergency Response");
        System.out.println("5. Exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.viewCameraFeed("camera01");
                    break;
                case 2:
                    user.setAlarm(true);
                    System.out.println("Alarm armed.");
                    break;
                case 3:
                    DoorLock lock = new DoorLock();
                    lock.lock();
                    System.out.println("Door locked.");
                    break;
                case 4:
                    Alert alert = new Alert();
                    user.receiveAlert(alert);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
