import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker3 {

    public static int[] getDigits(int number) {

        String str = String.valueOf(number);

        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }

    public static int[] reverseArray(int[] arr) {

        int[] reverse = new int[arr.length];

        int j = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse[j++] = arr[i];
        }

        return reverse;
    }

    public static boolean compareArrays(int[] a,
                                        int[] b) {

        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int[] digits) {

        return compareArrays(
                digits,
                reverseArray(digits));
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit == 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Digits = "
                + Arrays.toString(digits));

        System.out.println("Reversed = "
                + Arrays.toString(
                reverseArray(digits)));

        System.out.println("Palindrome = "
                + isPalindrome(digits));

        System.out.println("Duck Number = "
                + isDuckNumber(digits));

        sc.close();
    }
}