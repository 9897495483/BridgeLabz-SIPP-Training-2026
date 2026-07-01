// File Name: SpaceMissionCrewManagementSystem.java

import java.util.*;

// Astronaut Class
class Astronaut {

    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Astronaut ID : " + astronautId +
               "\nName         : " + name +
               "\nSpecialization : " + specialization;
    }
}

// Main Class
public class SpaceMissionCrewManagementSystem {

    // Mission Name -> List of Astronauts
    private HashMap<String, List<Astronaut>> missions = new HashMap<>();

    // Mission Name -> Set of Astronaut IDs (to prevent duplicates)
    private HashMap<String, HashSet<String>> assignedIds = new HashMap<>();

    // Add Mission
    public void addMission(String missionName) {

        if (!missions.containsKey(missionName)) {

            missions.put(missionName, new ArrayList<>());
            assignedIds.put(missionName, new HashSet<>());

            System.out.println(missionName + " mission created.");
        } else {
            System.out.println("Mission already exists.");
        }
    }

    // Assign Astronaut
    public void assignAstronaut(String missionName,
                                Astronaut astronaut) {

        if (!missions.containsKey(missionName)) {
            System.out.println("Mission not found.");
            return;
        }

        HashSet<String> ids = assignedIds.get(missionName);

        if (ids.contains(astronaut.astronautId)) {

            System.out.println("Duplicate Assignment! "
                    + astronaut.name +
                    " is already assigned to "
                    + missionName);

            return;
        }

        missions.get(missionName).add(astronaut);
        ids.add(astronaut.astronautId);

        System.out.println(astronaut.name +
                " assigned to " + missionName);
    }

    // Display Missions
    public void displayMissions() {

        System.out.println("\n===== Mission Details =====");

        for (String mission : missions.keySet()) {

            System.out.println("\nMission : " + mission);

            List<Astronaut> crew = missions.get(mission);

            for (Astronaut astronaut : crew) {

                System.out.println("--------------------");
                System.out.println(astronaut);
            }

            System.out.println("--------------------");
            System.out.println("Total Crew Members : "
                    + crew.size());
        }
    }

    public static void main(String[] args) {

        SpaceMissionCrewManagementSystem system =
                new SpaceMissionCrewManagementSystem();

        // Create Missions
        system.addMission("Chandrayaan-4");
        system.addMission("Mars Explorer");

        // Astronauts
        Astronaut a1 = new Astronaut(
                "A101",
                "Rahul",
                "Pilot");

        Astronaut a2 = new Astronaut(
                "A102",
                "Amit",
                "Scientist");

        Astronaut a3 = new Astronaut(
                "A103",
                "Neha",
                "Engineer");

        // Assign Astronauts
        system.assignAstronaut("Chandrayaan-4", a1);
        system.assignAstronaut("Chandrayaan-4", a2);

        system.assignAstronaut("Mars Explorer", a2);
        system.assignAstronaut("Mars Explorer", a3);

        // Duplicate Assignment
        system.assignAstronaut("Chandrayaan-4", a1);

        // Display All Missions
        system.displayMissions();
    }
}