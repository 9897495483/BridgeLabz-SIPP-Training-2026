import java.util.*;

public class TopKHighestSpendingCustomers {

    static List<Integer> findTopKTransactions(int[] transactions,
                                              int k) {

        PriorityQueue<Integer> minimumHeap =
                new PriorityQueue<>();

        for (int amount : transactions) {

            if (minimumHeap.size() < k) {

                minimumHeap.offer(amount);

            } else if (amount > minimumHeap.peek()) {

                minimumHeap.poll();

                minimumHeap.offer(amount);
            }
        }

        return new ArrayList<>(minimumHeap);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] transactions = new int[size];

        for (int index = 0; index < size; index++) {
            transactions[index] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        System.out.println(findTopKTransactions(transactions, k));
    }
}