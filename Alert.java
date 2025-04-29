import java.time.LocalDateTime;

public class Alert {
    private String alertID;
    private LocalDateTime timestamp;
    private String message;
    private String severity;

    public void sendToUser(User user) {}
    public void escalateToEmergency() {}
}