import java.util.*;

public class Main {

    private static HomeAdminUser homeAdminUser = new HomeAdminUser("Admin", "admin@homesafe", "admin123", "0000000000");
    private static List<HomeUser> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Initializing HomeSafe System...");
        while (true) {
            System.out.println("\n==== HomeSafe Menu ====");
            System.out.println("1. Create new user");
            System.out.println("2. Login as user");
            System.out.println("3. Login as admin");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createUser();
                    break;
                case "2":
                    loginAsUser();
                    break;
                case "3":
                    loginAsAdmin();
                    break;
                case "4":
                    System.out.println("Shutting down system.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        HomeUser newUser = new HomeUser(name, email, password, phone);
        users.add(newUser);
        System.out.println("User created.");
    }

    private static void loginAsUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        HomeUser user = users.stream()
            .filter(u -> u.email.equals(email))
            .findFirst()
            .orElse(null);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        user.login();
        SystemLog.recordEvent("User Login", user);
        populateDefaultDevices(user); // for demo
        userMenu(user);
    }

    private static void loginAsAdmin() {
        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine();
        if (!pass.equals(homeAdminUser.password)) {
            System.out.println("Wrong password.");
            return;
        }

        homeAdminUser.login();
        SystemLog.recordEvent("Admin Login", homeAdminUser);
        adminMenu();
    }

    private static void userMenu(HomeUser user) {
        while (true) {
            System.out.println("\n== User Menu ==");
            System.out.println("1. View Camera Feed");
            System.out.println("2. Set Alarm");
            System.out.println("3. Configure Sensor");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("Enter camera ID: ");
                    user.viewCameraFeed(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Arm alarm? (true/false): ");
                    user.setAlarm(Boolean.parseBoolean(scanner.nextLine()));
                    break;
                case "3":
                    System.out.print("Enter sensor ID: ");
                    user.configureDevice(scanner.nextLine());
                    break;
                case "4":
                    user.logout();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n== Admin Menu ==");
            System.out.println("1. Add device to user");
            System.out.println("2. View system logs");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine()) {
                case "1":
                    addDeviceToUser();
                    break;
                case "2":
                    System.out.print("Enter userID to view logs: ");
                    SystemLog.retrieveLogs(scanner.nextLine());
                    break;
                case "3":
                    homeAdminUser.logout();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addDeviceToUser() {
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();
        HomeUser user = users.stream()
            .filter(u -> u.email.equals(email))
            .findFirst()
            .orElse(null);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Choose device to add: 1.Camera 2.MotionSensor 3.CO2Sensor 4.DoorLock 5.Blinds");
        String option = scanner.nextLine();
        Device d = null;
        System.out.print("Enter Device ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Location: ");
        String loc = scanner.nextLine();

        switch (option) {
            case "1":
                d = new Camera(); break;
            case "2":
                d = new MotionSensor(); break;
            case "3":
                d = new CO2Sensor(); break;
            case "4":
                d = new DoorLock(); break;
            case "5":
                d = new Blinds(); break;
            default:
                System.out.println("Invalid device.");
                return;
        }

        d.setDeviceID(id);
        d.setLocation(loc);
        d.setStatus("Initialized");
        user.addDevice(d);
        System.out.println("Device added.");
        SystemLog.recordEvent("Device Added: " + id, user);
    }

    private static void populateDefaultDevices(HomeUser user) {
        if (user.getDeviceList().isEmpty()) {
            Camera c = new Camera();
            c.setDeviceID("cam01");
            c.setLocation("Front Door");
            c.setStatus("Idle");

            MotionSensor m = new MotionSensor();
            m.setDeviceID("ms01");
            m.setLocation("Living Room");
            m.setStatus("Normal");

            user.addDevice(c);
            user.addDevice(m);
        }
    }
}