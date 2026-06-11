import java.util.Scanner;

public class Friends {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }

        int youngest = 0;
        int tallest = 0;

        for (int i = 1; i < 3; i++) {

            if (ages[i] < ages[youngest])
                youngest = i;

            if (heights[i] > heights[tallest])
                tallest = i;
        }

        System.out.println("Youngest Friend = " + names[youngest]);
        System.out.println("Tallest Friend = " + names[tallest]);
    }
}