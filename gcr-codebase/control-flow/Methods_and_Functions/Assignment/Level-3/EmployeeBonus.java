import java.util.Arrays;

public class EmployeeBonus {

    public static double[][] generateEmployeeData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {

            data[i][0] = (int)(Math.random() * 90000) + 10000; // Salary
            data[i][1] = (int)(Math.random() * 10) + 1;        // Years
        }

        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[10][2];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];

            double bonus;

            if (years > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }

        return result;
    }

    public static void main(String[] args) {

        double[][] employees = generateEmployeeData();
        double[][] result = calculateBonus(employees);

        double oldTotal = 0;
        double newTotal = 0;
        double bonusTotal = 0;

        System.out.println("OldSalary\tYears\tBonus\tNewSalary");

        for (int i = 0; i < employees.length; i++) {

            System.out.printf("%.0f\t\t%.0f\t%.2f\t%.2f%n",
                    employees[i][0],
                    employees[i][1],
                    result[i][1],
                    result[i][0]);

            oldTotal += employees[i][0];
            newTotal += result[i][0];
            bonusTotal += result[i][1];
        }

        System.out.println("\nTotal Old Salary = " + oldTotal);
        System.out.println("Total Bonus = " + bonusTotal);
        System.out.println("Total New Salary = " + newTotal);
    }
}