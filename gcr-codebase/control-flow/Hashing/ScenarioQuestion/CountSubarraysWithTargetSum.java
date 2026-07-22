import java.util.*;

public class CountSubarraysWithTargetSum {

    public static int countSubarrays(int[] revenueChanges, int targetSum) {

        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();

        prefixSumFrequency.put(0, 1);

        int currentPrefixSum = 0;
        int totalSubarrays = 0;

        for (int revenue : revenueChanges) {

            currentPrefixSum += revenue;

            totalSubarrays += prefixSumFrequency.getOrDefault(currentPrefixSum - targetSum, 0);

            prefixSumFrequency.put(
                    currentPrefixSum,
                    prefixSumFrequency.getOrDefault(currentPrefixSum, 0) + 1
            );
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] revenueChanges = new int[size];

        System.out.println("Enter revenue changes:");

        for (int index = 0; index < size; index++) {
            revenueChanges[index] = scanner.nextInt();
        }

        System.out.print("Enter target sum: ");
        int targetSum = scanner.nextInt();

        System.out.println(countSubarrays(revenueChanges, targetSum));
    }
}