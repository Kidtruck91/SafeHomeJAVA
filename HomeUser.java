import java.util.List;

public class HomeUser extends User {
    
    private List<Device> devices;

    public HomeUser(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = "User";
    }

    public void viewCameraFeed(String deviceID) {
        // Access camera feed logic
    }

    public void setAlarm(boolean status) {
        // Logic to arm/disarm
    }

    public void configureDevice(String deviceID) {
        // Configure logic
    }

     // Setter for name
     public void setName(String name) {
        this.name = name;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter for phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // Getter for name
    public String getName() {
        return name;
    }
    // Getter for password
    public String getPassword() {
        return password;
    }
    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // Getter for role
    public String getRole() {
        return role;
    }
    // Getter for userID
    public String getUserID() {
        return userID;
    }
    // Getter for email
    public String getEmail() {
        return email;
    }
    // Getter for devices
    public List<Device> getDevices() {
        return devices;
    }
    // Setter for devices
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
    // Method to add a device to the user's list of devices
    public void addDevice(Device device) {
        if (devices != null) {
            devices.add(device);
        } else {
            System.out.println("Device list is not initialized.");
        }
    }
    // Method to remove a device from the user's list of devices
    public void removeDevice(Device device) {
        if (devices != null && devices.contains(device)) {
            devices.remove(device);
        } else {
            System.out.println("Device not found in the list.");
        }
    }
    // Method to view the list of devices
    public void viewDevices() {
        if (devices != null && !devices.isEmpty()) {
            System.out.println("Devices: ");
            for (Device device : devices) {
                System.out.println(device.getDeviceID());
            }
        } else {
            System.out.println("No devices found.");
        }
    }
    // Method to view the status of a specific device
    public void viewDeviceStatus(String deviceID) {
        if (devices != null) {
            for (Device device : devices) {
                if (device.getDeviceID().equals(deviceID)) {
                    System.out.println("Device ID: " + device.getDeviceID() + ", Status: " + device.getStatus());
                    return;
                }
            }
            System.out.println("Device not found.");
        } else {
            System.out.println("Device list is not initialized.");
        }
    }
    // Method to view the status of all devices
    public void viewAllDeviceStatus() {
        if (devices != null && !devices.isEmpty()) {
            System.out.println("All Device Status: ");
            for (Device device : devices) {
                System.out.println(device.getDeviceID() + ": " + device.getStatus());
            }
        } else {
            System.out.println("No devices found.");
        }
    }
    public void configureSecuritySettings(String status) {
        if (!status.equalsIgnoreCase("On") && !status.equalsIgnoreCase("Off")) {
            System.out.println("Error: Invalid option. Please type 'On' or 'Off'.");
            return;
        }
    
        if (devices.isEmpty()) {
            System.out.println("No devices found.");
        } else {
            for (Device device : devices) {
                device.setStatus(status);
            }
            System.out.println("All devices have been set to '" + status + "'.");
        }
    }
    

    @Override
    public boolean login(String name, String password) {
        boolean isValid = false;
        if (this.name.equals(name) && this.password.equals(password)) {
            System.out.println("Login successful!");
            isValid = true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        return isValid;
    }
    @Override
    public void logout() {}
    @Override
    public void receiveAlert(Alert alert) {}
}
