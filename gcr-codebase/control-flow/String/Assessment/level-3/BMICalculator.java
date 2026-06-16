import java.util.Scanner;

public class BMICalculator {

    static String getStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static String[][] calculateBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double height = data[i][1] / 100.0;

            double bmi = weight / (height * height);

            result[i][0] = String.valueOf(data[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = getStatus(bmi);
        }

        return result;
    }

    static void display(String[][] arr) {

        System.out.println("Height(cm)\tWeight\tBMI\tStatus");

        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" +
                    row[1] + "\t" +
                    row[2] + "\t" +
                    row[3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][2];

        for (int i = 0; i < 10; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Weight(kg): ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Height(cm): ");
            persons[i][1] = sc.nextDouble();
        }

        String[][] result = calculateBMI(persons);

        display(result);

        sc.close();
    }
}