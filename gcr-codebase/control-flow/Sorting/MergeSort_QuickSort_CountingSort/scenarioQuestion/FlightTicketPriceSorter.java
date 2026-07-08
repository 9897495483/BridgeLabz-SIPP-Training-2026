import java.util.Scanner;

public class FlightTicketPriceSorter {

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of ticket prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter ticket prices:");

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Ticket Prices:");

        for (int price : prices)
            System.out.print(price + " ");

        sc.close();
    }
}