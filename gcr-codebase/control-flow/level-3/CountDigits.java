import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int count = 0;

        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                count++;
                number /= 10;
            }
        }

        System.out.println("Digits = " + count);
    }
}