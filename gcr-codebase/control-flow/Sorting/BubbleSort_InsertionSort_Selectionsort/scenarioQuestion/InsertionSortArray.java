import java.util.Scanner;

public class InsertionSortArray {

    static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {

                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        insertionSort(nums);

        for (int num : nums)
            System.out.print(num + " ");

        sc.close();
    }
}