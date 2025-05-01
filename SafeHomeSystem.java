import java.util.Scanner;

public class SafeHomeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create test devices
        Camera camera = new Camera();
        camera.setDeviceID("cam01");
        camera.setLocation("Front Door");
        camera.setStatus("Idle");

        DoorLock doorLock = new DoorLock();
        doorLock.setDeviceID("lock01");
        doorLock.setLocation("Back Door");
        doorLock.setStatus("Unlocked");

        MotionSensor motionSensor = new MotionSensor();
        motionSensor.setDeviceID("motion01");
        motionSensor.setLocation("Living Room");
        motionSensor.setStatus("Normal");

        Blinds blinds = new Blinds();
        blinds.setDeviceID("blinds01");
        blinds.setLocation("Bedroom");
        blinds.setStatus("Closed");

        EmergencyResponder responder = new EmergencyResponder();
        responder.name = "Responder One";

        System.out.println("=== SafeHome Device Test ===");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. View Camera Feed");
            System.out.println("2. Lock the Door");
            System.out.println("3. Unlock the Door");
            System.out.println("4. Open Blinds");
            System.out.println("5. Close Blinds");
            System.out.println("6. Trigger Motion Sensor Alert");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    camera.streamVideo();
                    break;
                case 2:
                    doorLock.lock();
                    break;
                case 3:
                    doorLock.unlock();
                    break;
                case 4:
                    blinds.open();
                    break;
                case 5:
                    blinds.close();
                    break;
                case 6:
                    Alert alert = motionSensor.generateAlert("Motion detected at " + motionSensor.getLocation(), "High");
                    alert.sendToUser(responder); // optionally simulate HomeUser here too
                    alert.escalateToEmergency(responder);
                    break;
                case 7:
                    System.out.println("Exiting test...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
