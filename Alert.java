import java.time.LocalDateTime;
import java.util.UUID;

public class Alert {
    private String alertID;
    private LocalDateTime timestamp;
    private String message;
    private String severity; // e.g., "Low", "Medium", "High"

    // Constructor
    public Alert(String message, String severity) {
        this.alertID = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.severity = severity;
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

    // Send alert to a user
    public void sendToUser(User user) {
        user.receiveAlert(this);
    }

    // Escalate logic (could integrate with EmergencyResponder or logs)
    public void escalateToEmergency() {
        System.out.println("[ALERT ESCALATION] Alert " + alertID + " escalated to emergency services:");
        System.out.println("Message: " + message);
        System.out.println("Severity: " + severity);
    }

    // Display summary
    public String getSummary() {
        return "[" + severity + "] " + message + " at " + timestamp;
    }
}