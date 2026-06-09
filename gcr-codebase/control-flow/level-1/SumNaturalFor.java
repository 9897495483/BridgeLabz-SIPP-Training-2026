import java.util.Scanner;

public class SumNaturalFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 0) {
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            int formula = n * (n + 1) / 2;

            System.out.println("For Loop Sum = " + sum);
            System.out.println("Formula Sum = " + formula);
            System.out.println("Equal? " + (sum == formula));
        }
    }
}