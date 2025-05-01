import java.util.ArrayList;
import java.util.List;

public class HomeAdminUser extends HomeUser {

    protected List<HomeUser> users; // List to keep track of users
    private List<SystemLog> systemLogs = new ArrayList<>(); // List to store system logs
    private List<Device> devices; // List to keep track of devices

    public HomeAdminUser(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
        this.role = "Admin";
        this.users = new ArrayList<>(); // Initialize the user list
        this.devices = new ArrayList<>(); // Initialize the device list
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
    public boolean updateUser(String email, String newName, String newPassword, String newPhoneNumber) {
        HomeUser userToUpdate = findUserByEmail(email);
        if (userToUpdate != null) {
            if (!newName.isEmpty()) {
                userToUpdate.setName(newName);
            }
            if (!newPassword.isEmpty()) {
                userToUpdate.setPassword(newPassword);
            }
            if (!newPhoneNumber.isEmpty()) {
                userToUpdate.setPhoneNumber(newPhoneNumber);
            }
            return true; // User updated successfully
        }
        return false; // User not found
    }

   

    public List<SystemLog> getSystemLogs() {
        return systemLogs;
    }

    // Method to add a log (optional, for testing purposes)
    public void addSystemLog(SystemLog log) {
        systemLogs.add(log);
}

    public void manageUserPermission(String userID) {}
    // Method to add a device
    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Device added successfully.");
    }
    // Method to delete a device by ID
    public boolean deleteDeviceByID(String deviceID) {
        for (Device device : devices) {
            if (device.getDeviceID().equals(deviceID)) {
                devices.remove(device);
                System.out.println("Device deleted successfully.");
                return true;
            }
        }
        System.out.println("Device not found.");
        return false;
    }
    // Method to list all devices (optional, for debugging or display purposes)
    public void listDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices found.");
        } else {
            System.out.println("List of devices:");
            for (Device device : devices) {
                System.out.println("Device ID: " + device.getDeviceID() + ", Location: " + device.getLocation());
            }
        }
    }
    public void updateSystemSettings() {}
}