import java.util.*;

public class FraudPairDetection {

    public static int[] findFraudPair(int[] transactionAmounts, int targetAmount) {

        Map<Integer, Integer> amountToIndexMap = new HashMap<>();

        for (int currentIndex = 0; currentIndex < transactionAmounts.length; currentIndex++) {

            int requiredAmount = targetAmount - transactionAmounts[currentIndex];

            if (amountToIndexMap.containsKey(requiredAmount)) {

                return new int[]{
                        amountToIndexMap.get(requiredAmount),
                        currentIndex
                };
            }

            amountToIndexMap.put(transactionAmounts[currentIndex], currentIndex);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int size = scanner.nextInt();

        int[] transactionAmounts = new int[size];

        System.out.println("Enter transaction amounts:");

        for (int index = 0; index < size; index++) {
            transactionAmounts[index] = scanner.nextInt();
        }

        System.out.print("Enter target amount: ");
        int targetAmount = scanner.nextInt();

        System.out.println(Arrays.toString(findFraudPair(transactionAmounts, targetAmount)));
    }
}