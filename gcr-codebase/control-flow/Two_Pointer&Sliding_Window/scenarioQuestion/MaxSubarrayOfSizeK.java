public class MaxSubarrayOfSizeK {

    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];

            // Window size becomes k
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);

                // Slide the window
                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSubarrayOfSizeK(cpuLoad, k);

        System.out.println("Maximum Sum: " + result);
    }
}