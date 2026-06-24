class Device {
    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(int deviceId,
               String status,
               int temperatureSetting) {

        super(deviceId, status);
        this.temperatureSetting =
                temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Device ID: "
                + deviceId);
        System.out.println("Status: "
                + status);
        System.out.println("Temperature: "
                + temperatureSetting + "°C");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {

        Thermostat t =
                new Thermostat(101,
                        "ON",
                        24);

        t.displayStatus();
    }
}