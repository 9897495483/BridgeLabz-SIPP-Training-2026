import java.util.Scanner;

public class NumberChecker5 {

    public static int sumProperDivisors(int n) {

        int sum = 0;

        for (int i = 1; i < n; i++) {

            if (n % i == 0)
                sum += i;
        }

        return sum;
    }

    public static boolean isPerfect(int n) {
        return sumProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumProperDivisors(n) < n;
    }

    public static int factorial(int n) {

        int fact = 1;

        for (int i = 1; i <= n; i++)
            fact *= i;

        return fact;
    }

    public static boolean isStrong(int n) {

        int original = n;
        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int n = sc.nextInt();

        System.out.println("Perfect = " + isPerfect(n));
        System.out.println("Abundant = " + isAbundant(n));
        System.out.println("Deficient = " + isDeficient(n));
        System.out.println("Strong = " + isStrong(n));

        sc.close();
    }
}