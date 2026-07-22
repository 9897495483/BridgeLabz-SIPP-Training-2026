import java.util.*;

class Patient {

    String patientName;
    int severityScore;

    Patient(String patientName, int severityScore) {
        this.patientName = patientName;
        this.severityScore = severityScore;
    }
}

public class EmergencyRoomTriageSystem {

    private static PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((firstPatient, secondPatient) ->
                    secondPatient.severityScore - firstPatient.severityScore);

    public static void addPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public static Patient treatNextPatient() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int patientCount = scanner.nextInt();
        scanner.nextLine();

        for (int index = 0; index < patientCount; index++) {

            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();

            System.out.print("Enter severity score: ");
            int severityScore = scanner.nextInt();
            scanner.nextLine();

            addPatient(new Patient(patientName, severityScore));
        }

        System.out.println("\nTreatment Order:");

        while (!triageQueue.isEmpty()) {
            Patient patient = treatNextPatient();
            System.out.println(patient.patientName + " -> " + patient.severityScore);
        }
    }
}