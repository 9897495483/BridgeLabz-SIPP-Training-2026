import java.util.Scanner;

public class GradeCard {

    static int[][] generateMarks(int n) {

        int[][] marks =
                new int[n][3];

        for(int i=0;i<n;i++) {

            for(int j=0;j<3;j++) {

                marks[i][j] =
                        (int)(Math.random()*101);
            }
        }

        return marks;
    }

    static String grade(double p) {

        if(p>=90) return "A+";
        if(p>=80) return "A";
        if(p>=70) return "B";
        if(p>=60) return "C";
        if(p>=50) return "D";

        return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "Enter Students: ");

        int n = sc.nextInt();

        int[][] marks =
                generateMarks(n);

        System.out.println(
                "Phy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for(int i=0;i<n;i++) {

            int total =
                    marks[i][0]
                            + marks[i][1]
                            + marks[i][2];

            double avg = total/3.0;

            double percent =
                    Math.round(avg*100.0)/100.0;

            System.out.println(
                    marks[i][0] + "\t"
                            + marks[i][1] + "\t"
                            + marks[i][2] + "\t"
                            + total + "\t"
                            + avg + "\t"
                            + percent + "\t"
                            + grade(percent));
        }

        sc.close();
    }
}