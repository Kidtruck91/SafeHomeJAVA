import java.time.LocalDateTime;
import java.util.UUID;

public class Alert {
    private String alertID;
    private LocalDateTime timestamp;
    private String message;
    private String severity; // e.g., "Low", "Medium", "High"
    private String deviceID;

    // Constructor
    public Alert(String message, String severity, String deviceID) {
        this.alertID = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.severity = severity;
        this.deviceID = deviceID;
    }

    // Getters
    public String getAlertID() {
        return alertID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSeverity() {
        return severity;
    }
    public String getDeviceID() { return deviceID; }
    
    
    
    // Send alert to a user
    public void sendToUser(User user) {
        user.receiveAlert(this);
    }
    public void setMessage(String message) { this.message = message; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setDeviceID(String deviceID) { this.deviceID = deviceID; }
    // Escalate logic (could integrate with EmergencyResponder or logs)
    public Alert escalateToEmergency(EmergencyResponder responder) {
        System.out.println("ESCALATING to Emergency Responder...");
        responder.receiveAlert(this);
        return this;
    }
    // Display summary
    public String getSummary() {
        return "[" + severity + "] " + message + " | Device: " + deviceID + " | Time: " + timestamp;
    }
}