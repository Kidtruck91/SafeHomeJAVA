public abstract class Device {
    protected String deviceID;
    protected String location;
    protected String status;

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
}