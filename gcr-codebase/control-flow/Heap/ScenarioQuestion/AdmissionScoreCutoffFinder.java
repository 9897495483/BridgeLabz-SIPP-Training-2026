import java.util.*;

public class AdmissionScoreCutoffFinder {

    static int findKthLargestScore(int[] applicantScores,
                                   int k) {

        PriorityQueue<Integer> minimumHeap =
                new PriorityQueue<>();

        for (int score : applicantScores) {

            if (minimumHeap.size() < k) {

                minimumHeap.offer(score);

            } else if (score > minimumHeap.peek()) {

                minimumHeap.poll();

                minimumHeap.offer(score);
            }
        }

        return minimumHeap.peek();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] scores = new int[size];

        for (int index = 0; index < size; index++) {
            scores[index] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        System.out.println(findKthLargestScore(scores, k));
    }
}