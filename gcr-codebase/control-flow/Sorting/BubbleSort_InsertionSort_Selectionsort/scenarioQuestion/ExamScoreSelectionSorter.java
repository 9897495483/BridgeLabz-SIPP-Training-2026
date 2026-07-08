import java.util.Scanner;

public class ExamScoreSelectionSorter {

    static void selectionSort(int[] scores) {

        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (scores[j] < scores[min])
                    min = j;
            }

            int temp = scores[i];
            scores[i] = scores[min];
            scores[min] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        selectionSort(scores);

        for (int score : scores)
            System.out.print(score + " ");

        sc.close();
    }
}