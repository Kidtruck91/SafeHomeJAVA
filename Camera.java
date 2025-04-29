public class Camera extends Device {
    public void streamVideo() {}
    public void detectMotion() {}

    @Override
    public String getStatus() { return status; }
    @Override
    public void updateSettings(String newStatus) { status = newStatus; }
}