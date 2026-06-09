import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double physics = sc.nextDouble();
        double chemistry = sc.nextDouble();
        double maths = sc.nextDouble();

        double percentage = (physics + chemistry + maths) / 3;

        char grade;
        String remarks;

        if (percentage >= 90) {
            grade = 'A';
            remarks = "Excellent";
        } else if (percentage >= 75) {
            grade = 'B';
            remarks = "Good";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "Average";
        } else if (percentage >= 40) {
            grade = 'D';
            remarks = "Pass";
        } else {
            grade = 'F';
            remarks = "Fail";
        }

        System.out.println("Percentage = " + percentage);
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remarks);
    }
}