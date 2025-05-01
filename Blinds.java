public class Blinds extends Device {

    public void open() {
        setStatus("Open");
        System.out.println("Blinds at " + getLocation() + " are open.");
    }

    public void close() {
        setStatus("Closed");
        System.out.println("Blinds at " + getLocation() + " are closed.");
    }

    @Override
    public String getStatus() {
        return "Blinds at " + getLocation() + ": " + getRawStatus();
    }

    @Override
    public void updateSettings(String newStatus) {
        setStatus(newStatus);
    }
}