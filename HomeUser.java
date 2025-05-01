import java.util.List;
import java.util.ArrayList;

public class HomeUser extends User {
    private List<Device> devices;

    public HomeUser(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = "User";
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }
    public List<Device> getDeviceList() {
        return devices;
    }
    public void viewCameraFeed(String deviceID) {
        for (Device d : devices) {
            if (d instanceof Camera && d.getDeviceID().equals(deviceID)) {
                ((Camera) d).streamVideo();
                return;
            }
        }
        System.out.println("No camera with ID: " + deviceID);
    }

    public void setAlarm(boolean status) {
        for (Device d : devices) {
            if (d instanceof Sensors) {
                ((Sensors) d).setAlarm(status);
            }
        }
    }

    public void configureDevice(String deviceID) {
        for (Device d : devices) {
            if (d instanceof Sensors && d.getDeviceID().equals(deviceID)) {
                ((Sensors) d).configureDevice(deviceID);
                return;
            }
        }
        System.out.println("Sensor not found with ID: " + deviceID);
    }

    @Override
    public void login() {
        System.out.println(name + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println(name + " logged out.");
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println("ALERT RECEIVED: " + alert.getSummary());
    }
}