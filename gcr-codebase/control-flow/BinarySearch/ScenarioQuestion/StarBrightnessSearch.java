import java.util.Scanner;

public class StarBrightnessSearch {

    // Normal Binary Search
    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // Search in Rotated Sorted Array
    static int searchRotated(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            // Left half is sorted
            if (arr[left] <= arr[mid]) {

                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Right half is sorted
            else {

                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    // First Occurrence
    static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    // Last Occurrence
    static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    // Minimum Element in Rotated Sorted Array
    static int findMinimum(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return arr[left];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stars: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter brightness values:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target brightness: ");
        int target = sc.nextInt();

        System.out.println("\nBinary Search Index: "
                + binarySearch(arr, target));

        System.out.println("First Occurrence: "
                + firstOccurrence(arr, target));

        System.out.println("Last Occurrence: "
                + lastOccurrence(arr, target));

        System.out.println("\nMinimum Element: "
                + findMinimum(arr));

        System.out.println("Search in Rotated Array: "
                + searchRotated(arr, target));

        sc.close();
    }
}