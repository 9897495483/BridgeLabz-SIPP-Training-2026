interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Activity data reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    public void logActivity() {
        System.out.println("Activity Logged.");
    }

    public void generateReport() {
        System.out.println("Weekly Fitness Report Generated.");
    }

    public void sendAlert() {
        System.out.println("Drink Water Reminder Sent.");
    }
}

public class fitnessTracker {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}