import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public static String getBMIStatus(double bmi) {

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] person = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            person[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm): ");
            person[i][1] = sc.nextDouble();

            person[i][2] = calculateBMI(person[i][0], person[i][1]);

            status[i] = getBMIStatus(person[i][2]);
        }

        System.out.println("\nWeight\tHeight\tBMI\tStatus");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
                    person[i][0],
                    person[i][1],
                    person[i][2],
                    status[i]);
        }

        sc.close();
    }
}