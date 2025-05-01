import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SystemLog {
    private static List<SystemLog> logs = new ArrayList<>();
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

    public static void recordEvent(String type, User user) {
        SystemLog log = new SystemLog(type, user);
        logs.add(log);
        System.out.println("LOG [" + log.logID + "]: " + log.eventType + " by " + user.name + " at " + log.time);
    }

    public static void retrieveLogs(String userID) {
        for (SystemLog log : logs) {
            if (log.user != null && log.user.userID.equals(userID)) {
                System.out.println(log.time + " - " + log.eventType);
            }
        }
    }
}