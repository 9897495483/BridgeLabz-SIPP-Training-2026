import java.util.Scanner;

public class FactorsOperations {

    public static int[] findFactors(int n) {

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

    public static int greatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static int sumFactors(int[] factors) {

        int sum = 0;

        for (int factor : factors)
            sum += factor;

        return sum;
    }

    public static long productFactors(int[] factors) {

        long product = 1;

        for (int factor : factors)
            product *= factor;

        return product;
    }

    public static double cubeProduct(int[] factors) {

        double product = 1;

        for (int factor : factors)
            product *= Math.pow(factor, 3);

        return product;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int n = sc.nextInt();

        int[] factors = findFactors(n);

        System.out.println("Greatest Factor = "
                + greatestFactor(factors));

        System.out.println("Sum = "
                + sumFactors(factors));

        System.out.println("Product = "
                + productFactors(factors));

        System.out.println("Cube Product = "
                + cubeProduct(factors));

        sc.close();
    }
}