import java.util.Scanner;

public class ProductPriceBubbleSorter {

    static void bubbleSort(int[] prices) {

        boolean swapped;

        for (int i = 0; i < prices.length - 1; i++) {

            swapped = false;

            for (int j = 0; j < prices.length - i - 1; j++) {

                if (prices[j] > prices[j + 1]) {

                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        bubbleSort(prices);

        for (int price : prices)
            System.out.print(price + " ");

        sc.close();
    }
}