import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        //Initialize a defualt admin user
        HomeAdminUser homeAdminUser = new HomeAdminUser( "Admin", "admin@homsafe","00000000","0000000000");
        
        System.out.println("Initializing HomeSafe System...");
        System.out.println("System initialized successfully.");
        System.out.println("Welcome to the HomeSafe System!");
        System.out.println("Please press 1 to create a new user or 2 to login as an admin.");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice == 1) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            HomeUser homeUser = new HomeUser(name, email, password, phoneNumber);
            System.out.println("User created successfully!");
        } else if (choice == 2) {
            System.out.print("Enter admin password: ");
            String adminPassword = scanner.nextLine();
            if (adminPassword.equals(homeAdminUser.password)) {
                System.out.println("Admin logged in successfully!");
                homeAdminUser.login();
            } else {
                System.out.println("Invalid admin password.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        while (true) {
            System.out.println("Welcome to the Home User System");
            System.out.println("1. View Camera Feed");
            System.out.println("2. Set Alarm");
            System.out.println("3. Configure Device");
            System.out.println("4. Login");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Device ID to view camera feed: ");
                    String deviceID = scanner.nextLine();
                    homeUser.viewCameraFeed(deviceID);
                    break;
                case 2:
                    System.out.print("Enter alarm status (true/false): ");
                    boolean status = scanner.nextBoolean();
                    homeUser.setAlarm(status);
                    break;
                case 3:
                    System.out.print("Enter Device ID to configure: ");
                    String configDeviceID = scanner.nextLine();
                    homeUser.configureDevice(configDeviceID);
                    break;
                case 4:
                    homeUser.login();
                    System.out.println("User logged in.");
                    break;
                case 5:
                    homeUser.logout();
                    System.out.println("User logged out.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}