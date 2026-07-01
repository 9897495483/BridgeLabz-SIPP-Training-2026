// File Name: SmartCityTrafficMonitoringSystem.java

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {

    // Road Name -> Vehicle Count
    private HashMap<String, Integer> trafficData = new HashMap<>();

    // Add or Update Vehicle Count
    public void addOrUpdateRoad(String roadName, int vehicles) {

        if (trafficData.containsKey(roadName)) {

            int total = trafficData.get(roadName) + vehicles;
            trafficData.put(roadName, total);

            System.out.println(roadName +
                    " updated successfully.");
        } else {

            trafficData.put(roadName, vehicles);

            System.out.println(roadName +
                    " added successfully.");
        }
    }

    // Display Roads in Sorted Order
    public void displaySortedRoads() {

        TreeMap<String, Integer> sortedRoads =
                new TreeMap<>(trafficData);

        System.out.println("\n===== Roads (Sorted) =====");

        for (Map.Entry<String, Integer> entry :
                sortedRoads.entrySet()) {

            System.out.println(entry.getKey()
                    + " -> "
                    + entry.getValue()
                    + " vehicles");
        }
    }

    // Display Busiest Road
    public void displayBusiestRoad() {

        String busiestRoad = "";
        int maxVehicles = 0;

        for (Map.Entry<String, Integer> entry :
                trafficData.entrySet()) {

            if (entry.getValue() > maxVehicles) {

                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }

        System.out.println("\n===== Busiest Road =====");
        System.out.println("Road Name : " + busiestRoad);
        System.out.println("Vehicles  : " + maxVehicles);
    }

    // Generate Traffic Report
    public void generateTrafficReport() {

        System.out.println("\n===== Traffic Analysis Report =====");

        for (Map.Entry<String, Integer> entry :
                trafficData.entrySet()) {

            String status;

            if (entry.getValue() >= 1000)
                status = "Heavy Traffic";
            else if (entry.getValue() >= 500)
                status = "Moderate Traffic";
            else
                status = "Low Traffic";

            System.out.println(entry.getKey()
                    + " : "
                    + entry.getValue()
                    + " vehicles"
                    + " --> "
                    + status);
        }
    }

    // Display Total Roads
    public void displayTotalRoads() {

        System.out.println("\nTotal Roads Monitored : "
                + trafficData.size());
    }

    public static void main(String[] args) {

        SmartCityTrafficMonitoringSystem system =
                new SmartCityTrafficMonitoringSystem();

        // Add Roads
        system.addOrUpdateRoad("MG Road", 750);
        system.addOrUpdateRoad("Ring Road", 1200);
        system.addOrUpdateRoad("Airport Road", 450);
        system.addOrUpdateRoad("Civil Lines", 600);

        // Update Existing Road
        system.addOrUpdateRoad("MG Road", 300);

        // Display Roads in Sorted Order
        system.displaySortedRoads();

        // Display Busiest Road
        system.displayBusiestRoad();

        // Generate Report
        system.generateTrafficReport();

        // Display Total Roads
        system.displayTotalRoads();
    }
}