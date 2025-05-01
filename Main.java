import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        //Initialize a defualt admin user
        HomeAdminUser homeAdminUser = new HomeAdminUser( "Admin", "admin@homsafe","00000000","0000000000");
        
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
            System.out.println("4. Login");
            System.out.println("5. Logout");
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
                            break;
            
                        case 2: // Update User
                            System.out.print("Enter the email of the user to update: ");
                            String updateEmail = scanner.nextLine();
                            // Assuming you have a method to find a user by email
                            HomeUser userToUpdate = homeAdminUser.findUserByEmail(updateEmail);
                            if (userToUpdate != null) {
                                System.out.print("Enter new name (leave blank to keep current): ");
                                String newName = scanner.nextLine();
                                if (!newName.isEmpty()) userToUpdate.setName(newName);
            
                                System.out.print("Enter new password (leave blank to keep current): ");
                                String newPassword = scanner.nextLine();
                                if (!newPassword.isEmpty()) userToUpdate.setPassword(newPassword);
            
                                System.out.print("Enter new phone number (leave blank to keep current): ");
                                String newPhoneNumber = scanner.nextLine();
                                if (!newPhoneNumber.isEmpty()) userToUpdate.setPhoneNumber(newPhoneNumber);
            
                                System.out.println("User updated successfully!");
                            } else {
                                System.out.println("User not found.");
                            }
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