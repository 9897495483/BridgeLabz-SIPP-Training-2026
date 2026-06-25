import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker1 {

    public static int countDigits(int number) {

        int count = 0;

        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static int[] getDigits(int number) {

        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit == 0)
                return true;
        }

        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {

        int sum = 0;
        int power = digits.length;

        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }

        return sum == number;
    }

    public static int[] largestAndSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            }
            else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static int[] smallestAndSecondSmallest(int[] digits) {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {

            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            }
            else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Digits: " + Arrays.toString(digits));

        System.out.println("Duck Number: "
                + isDuckNumber(digits));

        System.out.println("Armstrong Number: "
                + isArmstrong(number, digits));

        int[] largest = largestAndSecondLargest(digits);

        System.out.println("Largest Digit = "
                + largest[0]);

        System.out.println("Second Largest Digit = "
                + largest[1]);

        int[] smallest = smallestAndSecondSmallest(digits);

        System.out.println("Smallest Digit = "
                + smallest[0]);

        System.out.println("Second Smallest Digit = "
                + smallest[1]);

        sc.close();
    }
}