public class DoorLock extends Device {

    public void lock() {
        setStatus("Locked");
        System.out.println("Door at " + getLocation() + " is now locked.");
    }

    public void unlock() {
        setStatus("Unlocked");
        System.out.println("Door at " + getLocation() + " is now unlocked.");
    }

    @Override
    public String getStatus() {
        return "DoorLock at " + getLocation() + ": " + getRawStatus();
    }

    @Override
    public void updateSettings(String newStatus) {
        setStatus(newStatus);
    }
}