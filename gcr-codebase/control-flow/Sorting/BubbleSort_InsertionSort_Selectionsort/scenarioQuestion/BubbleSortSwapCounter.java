import java.util.Scanner;

public class BubbleSortSwapCounter {

    static int bubbleSort(int[] nums) {

        int swaps = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return swaps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int swaps = bubbleSort(nums);

        System.out.println("Total Swaps = " + swaps);

        sc.close();
    }
}