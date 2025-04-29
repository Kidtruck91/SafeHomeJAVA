public class CO2Sensor extends Sensors {
    @Override
    public void configureDevice(String deviceID) {}
    @Override
    public void setAlarm(boolean status) {}
    @Override
    public void receiveAlert(Alert alert) {}

    @Override
    public String getStatus() { return status; }
    @Override
    public void updateSettings(String newStatus) { status = newStatus; }
}