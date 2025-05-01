import java.util.ArrayList;
import java.util.List;

public class HomeAdminUser extends HomeUser {

    private List<HomeUser> users; // List to keep track of users

    public HomeAdminUser(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.role = "Admin";
        this.users = new ArrayList<>(); // Initialize the user list
    }

    // Method to add a user
    public void addUser(HomeUser user) {
        users.add(user);
        System.out.println("User added successfully.");
    }

    // Method to remove a user by email
    public boolean removeUserByEmail(String email) {
        for (HomeUser user : users) {
            if (user.getEmail().equals(email)) {
                users.remove(user);
                System.out.println("User removed successfully.");
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }

    // Method to find a user by email
    public HomeUser findUserByEmail(String email) {
        for (HomeUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    // Method to list all users
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of users:");
            for (HomeUser user : users) {
                System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail());
            }
        }
    }

    public void manageUserPermission(String userID) {}
    public void viewSystemLogs() {}
    public void updateSystemSettings() {}
}