// File Name: VehicleTollManagement.java

// Superclass
class Vehicle {

    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    // Method to calculate toll (Overridden in subclasses)
    double calculateToll() {
        return 0;
    }
}

// Car Class
class Car extends Vehicle {

    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 100;
    }
}

// Bus Class
class Bus extends Vehicle {

    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 250;
    }
}

// Truck Class
class Truck extends Vehicle {

    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    double calculateToll() {
        return 400;
    }
}

// Main Class
public class VehicleTollManagement {

    // Calculate Total Revenue
    static void calculateTotalRevenue(Vehicle[] vehicles) {

        double totalRevenue = 0;

        for (Vehicle vehicle : vehicles) {
            totalRevenue += vehicle.calculateToll();
        }

        System.out.println("\nTotal Revenue = ₹" + totalRevenue);
    }

    // Search Vehicle
    static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {

        boolean found = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.vehicleNumber.equals(vehicleNumber)) {

                System.out.println("\nVehicle Found");
                System.out.println("Vehicle Number : " + vehicle.vehicleNumber);
                System.out.println("Owner Name     : " + vehicle.ownerName);
                System.out.println("Toll Paid      : ₹" + vehicle.calculateToll());

                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("\nVehicle Not Found");
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {

                new Car("UP32AB1234", "Rahul"),
                new Bus("DL01XY5678", "Amit"),
                new Truck("RJ14PQ1111", "Riya"),
                new Car("HR26MN2222", "Neha"),
                new Truck("MP09GH3333", "Karan")
        };

        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        double highestToll = 0;
        Vehicle highestVehicle = null;

        System.out.println("===== Toll Details =====\n");

        // Dynamic Method Dispatch
        for (Vehicle vehicle : vehicles) {

            System.out.println("Vehicle Number : " + vehicle.vehicleNumber);
            System.out.println("Owner Name     : " + vehicle.ownerName);
            System.out.println("Toll Paid      : ₹" + vehicle.calculateToll());

            System.out.println("----------------------------");

            if (vehicle.calculateToll() > highestToll) {
                highestToll = vehicle.calculateToll();
                highestVehicle = vehicle;
            }

            if (vehicle instanceof Car)
                carCount++;
            else if (vehicle instanceof Bus)
                busCount++;
            else if (vehicle instanceof Truck)
                truckCount++;
        }

        calculateTotalRevenue(vehicles);

        searchVehicle(vehicles, "RJ14PQ1111");

        System.out.println("\n===== Highest Toll =====");
        System.out.println("Vehicle Number : " + highestVehicle.vehicleNumber);
        System.out.println("Owner Name     : " + highestVehicle.ownerName);
        System.out.println("Toll Paid      : ₹" + highestVehicle.calculateToll());

        System.out.println("\n===== Vehicle Count =====");
        System.out.println("Cars   : " + carCount);
        System.out.println("Buses  : " + busCount);
        System.out.println("Trucks : " + truckCount);
    }
}