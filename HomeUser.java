import java.util.List;

public class HomeUser extends User {
    private List<Device> devices;

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
    public void login() {}
    @Override
    public void logout() {}
    @Override
    public void receiveAlert(Alert alert) {}
}
