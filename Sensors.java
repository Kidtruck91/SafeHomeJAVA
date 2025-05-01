public abstract class Sensors extends Device {

    // Each sensor must implement these core behaviors
    public abstract void configureDevice(String deviceID);
    public abstract void setAlarm(boolean status);
    public abstract void receiveAlert(Alert alert);

    // Optionally: provide shared logic (can be overridden if needed)
    public void resetSensor() {
        setStatus("Normal");
        System.out.println(getClass().getSimpleName() + " at " + getLocation() + " reset to normal state.");
    }
}