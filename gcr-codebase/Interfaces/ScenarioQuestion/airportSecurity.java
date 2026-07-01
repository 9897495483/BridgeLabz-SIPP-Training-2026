interface LuggageScanner {

    void scanLuggage();

    default void displaySecurityGuidelines() {
        System.out.println("Check luggage carefully.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}

interface PassportVerifier {

    void verifyPassport();

    default void displaySecurityGuidelines() {
        System.out.println("Verify passport before boarding.");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    public void scanLuggage() {
        System.out.println("Luggage Scanned.");
    }

    public void verifyPassport() {
        System.out.println("Passport Verified.");
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }
}

public class airportSecurity {

    public static void main(String[] args) {

        String passengers[] = {
                "Rahul",
                "Amit",
                "Neha"
        };

        String passports[] = {
                "AB123456",
                "123",
                "XY987654"
        };

        AirportSecuritySystem system = new AirportSecuritySystem();

        system.displaySecurityGuidelines();

        for (int i = 0; i < passengers.length; i++) {

            System.out.print(passengers[i] + " : ");

            if (LuggageScanner.isPassportNumberValid(passports[i]))
                System.out.println("Allowed to Board");
            else
                System.out.println("Denied");
        }
    }
}