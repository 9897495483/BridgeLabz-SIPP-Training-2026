// File Name: EventEntryVerificationSystem.java

import java.util.HashSet;

public class EventEntryVerificationSystem {

    // HashSet to store unique participant email IDs
    private HashSet<String> participants = new HashSet<>();

    // Register Participant
    public void registerParticipant(String email) {

        if (participants.add(email)) {
            System.out.println(email + " registered successfully.");
        } else {
            System.out.println("Duplicate Registration! " + email +
                    " is already registered.");
        }
    }

    // Display All Participants
    public void displayParticipants() {

        System.out.println("\n===== Registered Participants =====");

        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {

            for (String email : participants) {
                System.out.println(email);
            }
        }

        System.out.println("\nTotal Eligible Participants : "
                + participants.size());
    }

    public static void main(String[] args) {

        EventEntryVerificationSystem event =
                new EventEntryVerificationSystem();

        // Register Participants
        event.registerParticipant("rahul@gmail.com");
        event.registerParticipant("amit@gmail.com");
        event.registerParticipant("riya@gmail.com");
        event.registerParticipant("neha@gmail.com");

        // Duplicate Registrations
        event.registerParticipant("amit@gmail.com");
        event.registerParticipant("rahul@gmail.com");

        // Display Registered Participants
        event.displayParticipants();
    }
}