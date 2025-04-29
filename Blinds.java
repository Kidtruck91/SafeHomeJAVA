public class Blinds extends Device {
    public void open() {}
    public void close() {}

    @Override
    public String getStatus() { return status; }
    @Override
    public void updateSettings(String newStatus) { status = newStatus; }
}