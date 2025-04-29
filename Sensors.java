public abstract class Sensors extends Device {
    public abstract void configureDevice(String deviceID);
    public abstract void setAlarm(boolean status);
    public abstract void receiveAlert(Alert alert);
}