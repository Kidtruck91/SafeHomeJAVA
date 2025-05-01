import java.time.LocalDateTime;

public class SystemLog {
    private String logID;
    private String eventType;
    private LocalDateTime time;
    private User user;

    public SystemLog(String eventType, User user) {
        this.logID = java.util.UUID.randomUUID().toString();
        this.eventType = eventType;
        this.time = LocalDateTime.now();
        this.user = user;
    }

    // Getter for logID
    public String getLogID() {
        return logID;
    }

    // Getter for eventType
    public String getEventType() {
        return eventType;
    }

    // Getter for time
    public LocalDateTime getTime() {
        return time;
    }

    // Getter for user
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "LOG [" + logID + "]: " + eventType + " by " + (user != null ? user.name : "Unknown User") + " at " + time;
    }
}