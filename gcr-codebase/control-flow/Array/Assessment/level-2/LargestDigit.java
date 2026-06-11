import java.util.Scanner;

public class LargestDigit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long number = sc.nextLong();

        int[] digits = new int[10];
        int index = 0;

        while (number != 0 && index < 10) {

            digits[index] = (int) (number % 10);
            number /= 10;
            index++;
        }

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest &&
                       digits[i] != largest) {

                secondLargest = digits[i];
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);
    }
}