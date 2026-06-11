import java.util.Scanner;

public class StudentGrade2D {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];

        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Student " + (i + 1));

            marks[i][0] = sc.nextInt(); // Physics
            marks[i][1] = sc.nextInt(); // Chemistry
            marks[i][2] = sc.nextInt(); // Maths

            if (marks[i][0] < 0 ||
                marks[i][1] < 0 ||
                marks[i][2] < 0) {

                System.out.println("Invalid Marks");
                i--;
            }
        }

        for (int i = 0; i < n; i++) {

            int total =
                    marks[i][0] +
                    marks[i][1] +
                    marks[i][2];

            percentage[i] = total / 3.0;

            if (percentage[i] >= 90)
                grade[i] = 'A';
            else if (percentage[i] >= 80)
                grade[i] = 'B';
            else if (percentage[i] >= 70)
                grade[i] = 'C';
            else if (percentage[i] >= 60)
                grade[i] = 'D';
            else
                grade[i] = 'F';
        }

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "Student " + (i + 1) +
                    " Percentage = " + percentage[i] +
                    " Grade = " + grade[i]);
        }
    }
}