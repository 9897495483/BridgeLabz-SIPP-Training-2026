// File Name: SmartParkingSlotManager.java

import java.util.ArrayList;

public class SmartParkingSlotManager {

    // ArrayList to store parked vehicle registration numbers
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    // Add Vehicle
    public void addVehicle(String vehicleNumber) {

        if (!parkedVehicles.contains(vehicleNumber)) {
            parkedVehicles.add(vehicleNumber);
            System.out.println(vehicleNumber + " entered the parking area.");
        } else {
            System.out.println(vehicleNumber + " is already parked.");
        }
    }

    // Remove Vehicle
    public void removeVehicle(String vehicleNumber) {

        if (parkedVehicles.remove(vehicleNumber)) {
            System.out.println(vehicleNumber + " exited the parking area.");
        } else {
            System.out.println(vehicleNumber + " not found.");
        }
    }

    // Search Vehicle
    public void searchVehicle(String vehicleNumber) {

        if (parkedVehicles.contains(vehicleNumber)) {
            System.out.println(vehicleNumber + " is currently parked.");
        } else {
            System.out.println(vehicleNumber + " is NOT parked.");
        }
    }

    // Display All Vehicles
    public void displayVehicles() {

        System.out.println("\n===== Parked Vehicles =====");

        if (parkedVehicles.isEmpty()) {
            System.out.println("Parking Area is Empty.");
        } else {
            for (String vehicle : parkedVehicles) {
                System.out.println(vehicle);
            }
        }

        System.out.println("\nTotal Occupied Parking Slots : "
                + parkedVehicles.size());
    }

    public static void main(String[] args) {

        SmartParkingSlotManager parking = new SmartParkingSlotManager();

        // Vehicles Enter
        parking.addVehicle("UP32AB1234");
        parking.addVehicle("DL01XY5678");
        parking.addVehicle("RJ14PQ9876");
        parking.addVehicle("HR26MN4567");

        // Duplicate Entry
        parking.addVehicle("UP32AB1234");

        System.out.println();

        // Search
        parking.searchVehicle("DL01XY5678");
        parking.searchVehicle("MP09AA1111");

        System.out.println();

        // Vehicle Exit
        parking.removeVehicle("RJ14PQ9876");

        // Vehicle Not Present
        parking.removeVehicle("RJ14PQ9876");

        // Display Remaining Vehicles
        parking.displayVehicles();
    }
}