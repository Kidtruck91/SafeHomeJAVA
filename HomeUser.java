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

    @Override
    public boolean login(name, password) {
        boolean isValid = false;
        if (this.name.equals(username) && this.password.equals(password)) {
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
