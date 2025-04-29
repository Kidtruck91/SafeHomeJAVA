public class DoorLock extends Device {
    public void lock() {}
    public void unlock() {}

    @Override
    public String getStatus() { return status; }
    @Override
    public void updateSettings(String newStatus) { status = newStatus; }
}