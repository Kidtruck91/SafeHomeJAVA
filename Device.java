public abstract class Device {
    protected String deviceID;
    protected String location;
    protected String status;
    protected String deviceType; // Automatically set based on the class name

    // Constructor
    public Device() {
        this.deviceType = this.getClass().getSimpleName(); // Set deviceType based on the class name
    }

    // Abstract methods
    public abstract String getStatus();
    public abstract void updateSettings(String newStatus);

    // Getters
    public String getDeviceID() {
        return deviceID;
    }

    public String getLocation() {
        return location;
    }

    public String getRawStatus() {
        return status;
    }

    public String getDeviceType() { // Getter for device type
        return deviceType;
    }

    // Setters
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Alert generateAlert(String message, String severity) {
        return new Alert(message, severity, this.deviceID);
    }
}