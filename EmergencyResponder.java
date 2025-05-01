public class EmergencyResponder extends User {
    public void accessLiveFeed() {
        System.out.println("EmergencyResponder accessing live feed...");
    }

    public void viewIncidentReport() {
        System.out.println("Viewing incident reports...");
    }

    @Override
    public void login() {
        System.out.println(name + " (Emergency Responder) logged in.");
    }

    @Override
    public void logout() {
        System.out.println(name + " (Emergency Responder) logged out.");
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println("Responder received alert: " + alert.getSummary());
    }
}