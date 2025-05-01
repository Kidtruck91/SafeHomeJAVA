public class MotionSensor extends Sensors {

    @Override
    public void configureDevice(String deviceID) {
        setDeviceID(deviceID);
        System.out.println("MotionSensor " + getDeviceID() + " configured.");
    }

    @Override
    public void setAlarm(boolean status) {
        setStatus(status ? "ALARM TRIGGERED" : "Normal");
        System.out.println("MotionSensor alarm set: " + getRawStatus());
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println("MotionSensor received alert: " + alert.getMessage());
    }

    @Override
    public String getStatus() {
        return "MotionSensor at " + getLocation() + ": " + getRawStatus();
    }

    @Override
    public void updateSettings(String newStatus) {
        setStatus(newStatus);
    }
}
