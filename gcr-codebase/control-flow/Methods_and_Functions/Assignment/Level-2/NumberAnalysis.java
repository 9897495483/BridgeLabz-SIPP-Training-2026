import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int n1, int n2) {

        if (n1 > n2)
            return 1;

        if (n1 < n2)
            return -1;

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {

            if (isPositive(num)) {

                if (isEven(num))
                    System.out.println(num + " is Positive Even");
                else
                    System.out.println(num + " is Positive Odd");

            } else {
                System.out.println(num + " is Negative");
            }
        }

        int result = compare(arr[0], arr[arr.length - 1]);

        if (result == 1)
            System.out.println("First element is greater");

        else if (result == -1)
            System.out.println("First element is smaller");

        else
            System.out.println("Both elements are equal");

        sc.close();
    }
}