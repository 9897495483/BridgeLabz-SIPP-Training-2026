import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker2 {

    public static int[] getDigits(int number) {

        String str = String.valueOf(number);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }

    public static int sumOfDigits(int[] digits) {

        int sum = 0;

        for (int digit : digits)
            sum += digit;

        return sum;
    }

    public static double sumOfSquares(int[] digits) {

        double sum = 0;

        for (int digit : digits)
            sum += Math.pow(digit, 2);

        return sum;
    }

    public static boolean isHarshad(int number,
                                    int[] digits) {

        return number % sumOfDigits(digits) == 0;
    }

    public static int[][] digitFrequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int digit : digits) {
            freq[digit][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Sum of Digits = "
                + sumOfDigits(digits));

        System.out.println("Sum of Squares = "
                + sumOfSquares(digits));

        System.out.println("Harshad Number = "
                + isHarshad(number, digits));

        int[][] freq = digitFrequency(digits);

        System.out.println("\nDigit Frequency");

        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0)
                System.out.println(
                        freq[i][0] + " -> "
                                + freq[i][1]);
        }

        sc.close();
    }
}