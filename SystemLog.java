import java.time.LocalDateTime;

public class SystemLog {
    private String logID;
    private String eventType;
    private LocalDateTime time;
    private User user;

    public void recordEvent(String type, User user) {}
    public void retrieveLogs(String userID) {}
}
