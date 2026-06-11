import java.util.Scanner;

public class NumberCheck {

    static void analyzeNumbers(int[] arr) {
        for (int num : arr) {
            if (num > 0) {
                if (num % 2 == 0)
                    System.out.println(num + " is Positive Even");
                else
                    System.out.println(num + " is Positive Odd");
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println("Zero");
            }
        }
    }

    static void compareFirstLast(int[] arr) {
        if (arr[0] > arr[arr.length - 1])
            System.out.println("First element is greater");
        else if (arr[0] < arr[arr.length - 1])
            System.out.println("First element is smaller");
        else
            System.out.println("Both are equal");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        analyzeNumbers(arr);
        compareFirstLast(arr);
    }
}