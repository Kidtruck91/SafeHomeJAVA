public class CO2Sensor extends Sensors {

    @Override
    public void configureDevice(String deviceID) {
        setDeviceID(deviceID);
        System.out.println("CO2Sensor " + getDeviceID() + " configured.");
    }

    @Override
    public void setAlarm(boolean status) {
        setStatus(status ? "ALARM TRIGGERED" : "Normal");
        System.out.println("CO2Sensor alarm set: " + getRawStatus());
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println("CO2Sensor received alert: " + alert.getMessage());
    }

    @Override
    public String getStatus() {
        return "CO2Sensor at " + getLocation() + ": " + getRawStatus();
    }

    @Override
    public void updateSettings(String newStatus) {
        setStatus(newStatus);
    }
}