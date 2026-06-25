import java.util.*;

public class FactorsProgram {

    static int[] findFactors(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                factors[index++] = i;
        }

        return factors;
    }

    static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum;
    }

    static long findProduct(int[] arr) {
        long product = 1;

        for (int num : arr)
            product *= num;

        return product;
    }

    static double findSumOfSquares(int[] arr) {
        double sum = 0;

        for (int num : arr)
            sum += Math.pow(num, 2);

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int[] factors = findFactors(n);

        System.out.println("Factors:");

        for (int factor : factors)
            System.out.print(factor + " ");

        System.out.println("\nSum = " + findSum(factors));
        System.out.println("Product = " + findProduct(factors));
        System.out.println("Sum of Squares = " + findSumOfSquares(factors));
    }
}