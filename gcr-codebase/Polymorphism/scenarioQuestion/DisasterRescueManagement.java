// File Name: DisasterRescueManagement.java

// Superclass
class RescueTeam {

    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    // Method to be overridden
    void performDuty() {
        System.out.println("Rescue Team is performing its duty.");
    }
}

// Medical Team
class MedicalTeam extends RescueTeam {

    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println(teamId +
                " : Medical Team is treating injured people at "
                + location);
    }
}

// Fire Rescue Team
class FireRescueTeam extends RescueTeam {

    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println(teamId +
                " : Fire Rescue Team is extinguishing fire at "
                + location);
    }
}

// Food Supply Team
class FoodSupplyTeam extends RescueTeam {

    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    void performDuty() {
        System.out.println(teamId +
                " : Food Supply Team is distributing food at "
                + location);
    }
}

// Main Class
public class DisasterRescueManagement {

    // Find team by location
    static void findTeamByLocation(RescueTeam[] teams,
                                   String searchLocation) {

        boolean found = false;

        System.out.println("\n===== Teams at " + searchLocation + " =====");

        for (RescueTeam team : teams) {

            if (team.location.equalsIgnoreCase(searchLocation)) {

                System.out.println(team.teamId + " -> "
                        + team.getClass().getSimpleName());

                found = true;
            }
        }

        if (!found)
            System.out.println("No teams found.");
    }

    // Display teams by ID prefix
    static void displayTeamsByPrefix(RescueTeam[] teams,
                                     String prefix) {

        boolean found = false;

        System.out.println("\n===== Teams with Prefix " + prefix + " =====");

        for (RescueTeam team : teams) {

            if (team.teamId.startsWith(prefix)) {

                System.out.println(team.teamId +
                        " (" + team.location + ")");

                found = true;
            }
        }

        if (!found)
            System.out.println("No matching teams.");
    }

    public static void main(String[] args) {

        RescueTeam[] teams = {

                new MedicalTeam("M101", "Delhi"),
                new FireRescueTeam("F201", "Mumbai"),
                new FoodSupplyTeam("FS301", "Delhi"),
                new MedicalTeam("M102", "Jaipur"),
                new FireRescueTeam("F202", "Delhi"),
                new FoodSupplyTeam("FS302", "Mumbai")
        };

        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        System.out.println("===== Rescue Operations =====\n");

        // Dynamic Method Dispatch
        for (RescueTeam team : teams) {

            team.performDuty();

            if (team instanceof MedicalTeam)
                medicalCount++;
            else if (team instanceof FireRescueTeam)
                fireCount++;
            else if (team instanceof FoodSupplyTeam)
                foodCount++;
        }

        findTeamByLocation(teams, "Delhi");

        displayTeamsByPrefix(teams, "M");

        System.out.println("\n===== Team Count =====");
        System.out.println("Medical Teams      : " + medicalCount);
        System.out.println("Fire Rescue Teams  : " + fireCount);
        System.out.println("Food Supply Teams  : " + foodCount);

        System.out.println("\n===== Maximum Deployment =====");

        if (medicalCount >= fireCount && medicalCount >= foodCount)
            System.out.println("Medical Team has the maximum deployments.");

        else if (fireCount >= medicalCount && fireCount >= foodCount)
            System.out.println("Fire Rescue Team has the maximum deployments.");

        else
            System.out.println("Food Supply Team has the maximum deployments.");
    }
}