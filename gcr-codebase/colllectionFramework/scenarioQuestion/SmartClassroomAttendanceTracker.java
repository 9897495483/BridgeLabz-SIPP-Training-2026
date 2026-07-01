// File Name: SmartClassroomAttendanceTracker.java

import java.util.ArrayList;
import java.util.HashMap;

public class SmartClassroomAttendanceTracker {

    // Key -> Subject Name
    // Value -> List of Students
    private HashMap<String, ArrayList<String>> attendance =
            new HashMap<>();

    // Mark Attendance
    public void markAttendance(String subject, String student) {

        // Create subject if it doesn't exist
        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        // Prevent duplicate attendance
        if (!students.contains(student)) {

            students.add(student);

            System.out.println(student +
                    " marked present in " + subject);
        } else {

            System.out.println(student +
                    " is already marked present in " + subject);
        }
    }

    // Display Attendance
    public void displayAttendance() {

        System.out.println("\n===== Attendance Report =====");

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject : " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println("Total Students : "
                    + students.size());
        }
    }

    public static void main(String[] args) {

        SmartClassroomAttendanceTracker tracker =
                new SmartClassroomAttendanceTracker();

        // Mark Attendance
        tracker.markAttendance("Java", "Rahul");
        tracker.markAttendance("Java", "Amit");
        tracker.markAttendance("Java", "Rahul");   // Duplicate

        tracker.markAttendance("Python", "Neha");
        tracker.markAttendance("Python", "Riya");

        tracker.markAttendance("DBMS", "Karan");
        tracker.markAttendance("DBMS", "Aman");

        // Display Attendance
        tracker.displayAttendance();
    }
}