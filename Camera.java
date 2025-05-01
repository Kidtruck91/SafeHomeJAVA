public class Camera extends Device {

    public void streamVideo() {
        System.out.println("Streaming video from camera at " + getLocation());
    }

    public void detectMotion() {
        System.out.println("Motion detected at " + getLocation() + "! Sending alert.");
    }

    @Override
    public String getStatus() {
        return "Camera at " + getLocation() + " status: " + getRawStatus();
    }

    @Override
    public void updateSettings(String newStatus) {
        setStatus(newStatus);
        System.out.println("Camera settings updated to: " + getRawStatus());
    }
}
