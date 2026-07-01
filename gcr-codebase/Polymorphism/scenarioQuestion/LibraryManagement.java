// File Name: LibraryManagement.java

// Superclass
class LibraryMember {

    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    // Method to calculate fine (Overridden in subclasses)
    double calculateFine(int overdueDays) {
        return 0;
    }

    // Method to print member details
    void printDetails() {
        System.out.println("Member Name : " + memberName);
        System.out.println("Member ID   : " + memberId);
    }
}

// Student Member
class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 2;     // ₹2 per day
    }
}

// Faculty Member
class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 1;     // ₹1 per day
    }
}

// Guest Member
class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 5;     // ₹5 per day
    }
}

// Main Class
public class LibraryManagement {

    // Search member by ID
    static void searchMember(LibraryMember[] members, String searchId) {

        boolean found = false;

        for (LibraryMember member : members) {

            if (member.memberId.equals(searchId)) {

                System.out.println("\n===== Member Found =====");
                member.printDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nMember with ID " + searchId + " not found.");
        }
    }

    public static void main(String[] args) {

        LibraryMember[] members = {

                new StudentMember("Rahul", "S101"),
                new FacultyMember("Amit", "F201"),
                new GuestMember("Riya", "G301"),
                new StudentMember("Neha", "S102")
        };

        int overdueDays = 4;

        System.out.println("===== Library Members =====\n");

        // Dynamic Method Dispatch
        for (LibraryMember member : members) {

            member.printDetails();

            System.out.println("Fine for "
                    + overdueDays
                    + " overdue days : ₹"
                    + member.calculateFine(overdueDays));

            System.out.println("----------------------------");
        }

        // Search by Member ID
        searchMember(members, "F201");
    }
}