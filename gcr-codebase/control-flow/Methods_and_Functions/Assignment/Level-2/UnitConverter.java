import java.util.*;

public class UnitConverter {

    static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();

        System.out.println(km + " km = "
                + convertKmToMiles(km) + " miles");

        System.out.print("Enter miles: ");
        double miles = sc.nextDouble();

        System.out.println(miles + " miles = "
                + convertMilesToKm(miles) + " km");

        System.out.print("Enter meters: ");
        double meters = sc.nextDouble();

        System.out.println(meters + " meters = "
                + convertMetersToFeet(meters) + " feet");

        System.out.print("Enter feet: ");
        double feet = sc.nextDouble();

        System.out.println(feet + " feet = "
                + convertFeetToMeters(feet) + " meters");
    }
}