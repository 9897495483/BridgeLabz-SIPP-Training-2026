interface HeartRateMonitor {

    void monitorHeartRate();

    default void displayHealthTips() {
        System.out.println("Exercise Daily.");
    }

    static boolean isPatientIdValid(String id) {
        return id.length() == 5;
    }
}

interface TemperatureMonitor {

    void monitorTemperature();

    default void displayHealthTips() {
        System.out.println("Drink Enough Water.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    public void monitorHeartRate() {
        System.out.println("Heart Rate Normal");
    }

    public void monitorTemperature() {
        System.out.println("Temperature Normal");
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }
}

public class healthMonitoring {

    public static void main(String[] args) {

        String names[] = {
                "Aman",
                "Riya",
                "Sohan"
        };

        String ids[] = {
                "P1001",
                "123",
                "P5005"
        };

        HealthMonitoringSystem hm = new HealthMonitoringSystem();

        hm.displayHealthTips();

        System.out.println();

        for (int i = 0; i < names.length; i++) {

            System.out.println(names[i]);

            if (HeartRateMonitor.isPatientIdValid(ids[i])) {
                hm.monitorHeartRate();
                hm.monitorTemperature();
                System.out.println("Healthy");
            } else {
                System.out.println("Invalid Patient ID");
            }

            System.out.println();
        }
    }
}