import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        //Initialize a defualt admin user
        HomeAdminUser homeAdminUser = new HomeAdminUser( "Admin", "admin@homsafe","00000000","0000000000");
                // Initialize a default emergency responder
        EmergencyResponder responder = new EmergencyResponder("Default Responder", "911", "emergency@responder.com");
        
        System.out.println("Initializing HomeSafe System...");
        System.out.println("System initialized successfully.");
        System.out.println("Welcome to the HomeSafe System!");
        System.out.println("Please login with default credentials to continue. ");
        System.out.println("Username: " );
        String username = scanner.nextLine();
        System.out.println("Password: " );
        String password = scanner.nextLine();
        // Check if the user is an admin
        do {homeAdminUser.login(username, password);}
        while (homeAdminUser.login(username, password) == false);

        while (true) {
            System.out.println("Welcome to the Home User System");
            System.out.println("1. Manage User Accounts");
            System.out.println("2. Configure Security Settings");
            System.out.println("3. Retrieve Activity Logs");
            System.out.println("4. Manage Devices");
            System.out.println("5. Log in as another user");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: //Manage User Accounts
                    while (true) {
                        System.out.println("Manage User Accounts:");
                        System.out.println("1. Add User");
                        System.out.println("2. Update User");
                        System.out.println("3. Delete User");
                        System.out.println("4. Go Back");
                        System.out.print("Choose an option: ");
                
                        int manageChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                
                        switch (manageChoice) {
                            case 1: // Add User
                                System.out.print("Enter your name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter your email: ");
                                String email = scanner.nextLine();
                                System.out.print("Enter your password: ");
                                password = scanner.nextLine();
                                System.out.print("Enter your phone number: ");
                                String phoneNumber = scanner.nextLine();
                
                                HomeUser newUser = new HomeUser(name, email, password, phoneNumber);
                                homeAdminUser.addUser(newUser); // Add user to the admin's list
                                System.out.println("User added successfully!");
                                SystemLog addUserLog = new SystemLog("Add User", homeAdminUser);
                                break;
                
                            case 2: // Update User
                                System.out.print("Enter the email of the user to update: ");
                                String updateEmail = scanner.nextLine();
                            
                                System.out.print("Enter new name (leave blank to keep current): ");
                                String newName = scanner.nextLine();
                            
                                System.out.print("Enter new password (leave blank to keep current): ");
                                String newPassword = scanner.nextLine();
                            
                                System.out.print("Enter new phone number (leave blank to keep current): ");
                                String newPhoneNumber = scanner.nextLine();
                            
                                boolean isUpdated = homeAdminUser.updateUser(updateEmail, newName, newPassword, newPhoneNumber);
                                if (isUpdated) {
                                    System.out.println("User updated successfully!");
                                } else {
                                    System.out.println("User not found.");
                                }
                                addUserLog = new SystemLog("update User", homeAdminUser);
                            break;
                
                            case 3: // Delete User
                                System.out.print("Enter the email of the user to delete: ");
                                String deleteEmail = scanner.nextLine();
                                boolean isDeleted = homeAdminUser.removeUserByEmail(deleteEmail);
                                if (isDeleted) {
                                    System.out.println("User deleted successfully!");
                                } else {
                                    System.out.println("User not found.");
                                }
                                addUserLog = new SystemLog("delete User", homeAdminUser);
                                break;
                
                            case 4: // Go Back
                                System.out.println("Returning to main menu...");
                                break;
                
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                
                        if (manageChoice == 4) {
                            break; // Exit the Manage User Accounts menu
                        }
                    }
                    break;
                case 2: // Configure Security Settings
                    System.out.print("Enter system status (On/Off): ");
                    String systemStatus = scanner.nextLine();
                
                    homeAdminUser.configureSecuritySettings(systemStatus);
                    SystemLog addUserLog = new SystemLog("Configured Security Settings", homeAdminUser);
                    break;
                case 3: // Retrieve Security Logs
                    System.out.println("Retrieving security logs...");
                    List<SystemLog> logs = homeAdminUser.getSystemLogs(); // Assuming this method exists in HomeAdminUser
                    if (logs == null || logs.isEmpty()) {
                        System.out.println("No security logs found.");
                    } else {
                        System.out.println("Security Log IDs:");
                        for (SystemLog log : logs) {
                            System.out.println("Log ID: " + log.getLogID());
                        }
                    }
                    break;
                case 4: // Manage Devices
                    while (true) {
                        System.out.println("Manage Devices:");
                        System.out.println("1. Add Device");
                        System.out.println("2. Delete Device");
                        System.out.println("3. Go Back");
                        System.out.println("4. Configure Device Settings");
                        System.out.println("5. View Device Status");
                        System.out.print("Choose an option: ");
                
                        int deviceChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                
                        switch (deviceChoice) {
                            case 1: // Add Device
                                System.out.print("Enter Device ID: ");
                                String deviceID = scanner.nextLine();
                                System.out.print("Enter Device Location: ");
                                String location = scanner.nextLine();
                
                                Device newDevice = new Device() { // Anonymous class for abstract Device
                                    {
                                        setDeviceID(deviceID);
                                        setLocation(location);
                                        setStatus("Off");
                                    }
                
                                    @Override
                                    public String getStatus() {
                                        return getRawStatus();
                                    }
                
                                    @Override
                                    public void updateSettings(String newStatus) {
                                        setStatus(newStatus);
                                    }
                                };
                
                                homeAdminUser.addDevice(newDevice);
                                 addUserLog = new SystemLog("Added Device", homeAdminUser);
                                break;
                
                            case 2: // Delete Device
                                System.out.print("Enter Device ID to delete: ");
                                String deleteDeviceID = scanner.nextLine();
                                boolean isDeleted = homeAdminUser.deleteDeviceByID(deleteDeviceID);
                                if (!isDeleted) {
                                    System.out.println("Device not found.");
                                }
                                 SystemLog deleteDeviceLog = new SystemLog("Deleted Device", homeAdminUser);
                                break;
                
                            case 3: // Go Back
                                System.out.println("Returning to main menu...");
                                break;
                                case 4: // Configure Device
                                    System.out.print("Enter the Device ID to configure: ");
                                     deviceID = scanner.nextLine();

                                   // Identify the device based on the ID and type
                                    Device deviceToConfigure = null;
                                    for (Device device : homeAdminUser.getDevices()) { // Assuming getDevices() returns a list of devices
                                        if (deviceID.equals(device.getDeviceID())) {
                                            deviceToConfigure = device;
                                            break;
                                        }
                                    }

                                    if (deviceToConfigure == null) {
                                        System.out.println("Device not found.");
                                        break;
                                    }

                                    // Provide specific options based on the device type
                                    boolean configuring = true;
                                    while (configuring) {
                                        System.out.println("\nChoose an action for the device:");
                                        if (deviceToConfigure instanceof Camera) {
                                            System.out.println("1. View Camera Feed");
                                            System.out.println("2. Exit Configuration");
                                        } else if (deviceToConfigure instanceof DoorLock) {
                                            System.out.println("1. Lock the Door");
                                            System.out.println("2. Unlock the Door");
                                            System.out.println("3. Exit Configuration");
                                        } else if (deviceToConfigure instanceof Blinds) {
                                            System.out.println("1. Open Blinds");
                                            System.out.println("2. Close Blinds");
                                            System.out.println("3. Exit Configuration");
                                        } else if (deviceToConfigure instanceof MotionSensor) {
                                            System.out.println("1. Trigger Motion Sensor Alert");
                                            System.out.println("2. Exit Configuration");
                                        }

                                        System.out.print("Enter choice: ");
                                        int configChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline

                                        switch (configChoice) {
                                            case 1:
                                                if (deviceToConfigure instanceof Camera) {
                                                    ((Camera) deviceToConfigure).streamVideo();
                                                    SystemLog configLog = new SystemLog("Streamed Video", homeAdminUser);
                                                } else if (deviceToConfigure instanceof DoorLock) {
                                                    ((DoorLock) deviceToConfigure).lock();
                                                    SystemLog configLog = new SystemLog("Locked Door", homeAdminUser);
                                                } else if (deviceToConfigure instanceof Blinds) {
                                                    ((Blinds) deviceToConfigure).open();
                                                    SystemLog configLog = new SystemLog("Opened Blinds", homeAdminUser);
                                                } else if (deviceToConfigure instanceof MotionSensor) {
                                                    Alert alert = ((MotionSensor) deviceToConfigure).generateAlert(
                                                        "Motion detected at " + deviceToConfigure.getLocation(), "High"
                                                    );
                                                    SystemLog configLog = new SystemLog("Triggered Motion Sensor Alert", homeAdminUser);
                                                    alert.sendToUser(responder);
                                                    alert.escalateToEmergency(responder);
                                                }
                                            
                                                break;

                                            case 2:
                                                if (deviceToConfigure instanceof DoorLock) {
                                                    ((DoorLock) deviceToConfigure).unlock();
                                                    SystemLog configLog2 = new SystemLog("Unlocked Door", homeAdminUser);
                                                } else if (deviceToConfigure instanceof Blinds) {
                                                    ((Blinds) deviceToConfigure).close();
                                                    SystemLog configLog2 = new SystemLog("Closed Blinds", homeAdminUser);
                                                } else {
                                                    configuring = false; // Exit configuration for Camera or MotionSensor
                                                }
                                                SystemLog configLog2 = new SystemLog("Configured Device", homeAdminUser);
                                                break;

                                            case 3:
                                                if (deviceToConfigure instanceof DoorLock || deviceToConfigure instanceof Blinds) {
                                                    configuring = false; // Exit configuration for DoorLock or Blinds
                                                } else {
                                                    System.out.println("Invalid choice.");
                                                }
                                                SystemLog configLog3 = new SystemLog("Configured Device", homeAdminUser);
                                                break;

                                            default:
                                                System.out.println("Invalid choice.");
                                        }
                                    }
                
                        if (deviceChoice == 3) {
                            break; // Exit the Manage Devices menu
                        }
                        break;
                    }
                }
                    
                case 5: // Log in as another user
                    System.out.println("Logging out current user...");
                    homeAdminUser.logout(); // Log out the current user

                    System.out.println("Enter new user credentials:");
                    System.out.print("Username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Password: ");
                    String newPassword = scanner.nextLine();

                    // Validate the new user credentials
                    boolean isLoggedIn = false;
                    User loggedInUser = null; // Track the logged-in user
                    for (HomeUser user : homeAdminUser.users) { // Assuming getUsers() returns a list of users
                        if (user.getName().equals(newUsername) && user.getPassword().equals(newPassword)) {
                            System.out.println("Login successful! Welcome, " + user.getName() + ".");
                            loggedInUser = user;
                            isLoggedIn = true;
                            break;
                        }
                    }

                    if (!isLoggedIn) {
                        System.out.println("Invalid credentials. Returning to main menu.");
                        break;
                    }

                    // Check the role of the logged-in user
                    if (loggedInUser instanceof HomeAdminUser) {
                        System.out.println("You are logged in as an Admin. You have full access.");
                    } else if (loggedInUser instanceof EmergencyResponder) {
                        System.out.println("You are logged in as an Emergency Responder. You can view devices.");
                    } else if (loggedInUser instanceof HomeUser) {
                        System.out.println("You are logged in as a User. You can view devices.");
                    } else {
                        System.out.println("Unknown role. Access restricted.");
                        break;
                    }

                    // Adjust menu options based on the role
                    while (true) {
                        System.out.println("Welcome to the Home User System");
                        if (loggedInUser instanceof HomeAdminUser) {
                            System.out.println("1. Manage User Accounts");
                            System.out.println("2. Configure Security Settings");
                            System.out.println("3. Retrieve Activity Logs");
                            System.out.println("4. Manage Devices");
                        }
                        System.out.println("5. View Devices");
                        System.out.println("6. Log in as another user");
                        System.out.println("7. Exit");
                        System.out.print("Choose an option: ");

                            choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (choice) {
                            case 1:
                                if (loggedInUser instanceof HomeAdminUser) {
                                    // Admin-specific functionality
                                    System.out.println("Managing user accounts...");
                                } else {
                                    System.out.println("Access denied. Only Admins can manage user accounts.");
                                }
                                break;

                            case 2:
                                if (loggedInUser instanceof HomeAdminUser) {
                                    // Admin-specific functionality
                                    System.out.println("Configuring security settings...");
                                } else {
                                    System.out.println("Access denied. Only Admins can configure security settings.");
                                }
                                break;

                            case 3:
                                if (loggedInUser instanceof HomeAdminUser) {
                                    // Admin-specific functionality
                                    System.out.println("Retrieving activity logs...");
                                } else {
                                    System.out.println("Access denied. Only Admins can retrieve activity logs.");
                                }
                                break;

                            case 4:
                                if (loggedInUser instanceof HomeAdminUser) {
                                    // Admin-specific functionality
                                    System.out.println("Managing devices...");
                                } else {
                                    System.out.println("Access denied. Only Admins can manage devices.");
                                }
                                break;

                            case 5:
                                // All roles can view devices
                                System.out.println("Viewing devices...");
                                for (Device device : homeAdminUser.getDevices()) {
                                    System.out.println("Device ID: " + device.getDeviceID() + ", Location: " + device.getLocation());
                                }
                                break;

                            case 6:
                                System.out.println("Logging in as another user...");
                                break;

                            case 7:
                                System.out.println("Exiting...");
                                scanner.close();
                                return;

                            default:
                                System.out.println("Invalid option. Please try again.");
                        }

                        if (choice == 6) {
                            break; // Exit to log in as another user
                        }
                    }
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