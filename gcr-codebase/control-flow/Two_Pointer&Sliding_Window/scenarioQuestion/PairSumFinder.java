public class PairSumFinder {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {1000, 2000, 3000, 4000, 5000};
        int target = 7000;

        int[] result = findPairSum(transactions, target);

        System.out.println("Pair: " + result[0] + ", " + result[1]);
    }
}