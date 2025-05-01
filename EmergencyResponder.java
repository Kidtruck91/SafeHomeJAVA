public class EmergencyResponder extends User {
    // Constructor
    public EmergencyResponder(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "Emergency Responder";
    }
    public void accessLiveFeed() {
        System.out.println("EmergencyResponder accessing live feed...");
    }

    public void viewIncidentReport() {
        System.out.println("Viewing incident reports...");
    }

    @Override
    public boolean login(String name, String password) {
        boolean isValid = false;
        if (this.name.equals(name) && this.password.equals(password)) {
            System.out.println("Login successful!");
            isValid = true;
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        return isValid;
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