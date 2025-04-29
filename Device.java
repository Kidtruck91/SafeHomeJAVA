public abstract class Device {
    protected String deviceID;
    protected String location;
    protected String status;

    public abstract String getStatus();
    public abstract void updateSettings(String newStatus);
}