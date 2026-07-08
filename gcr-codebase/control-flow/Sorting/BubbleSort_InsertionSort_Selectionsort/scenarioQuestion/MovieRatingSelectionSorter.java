import java.util.Scanner;

public class MovieRatingSelectionSorter {

    static void selectionSort(int[] ratings) {

        for (int i = 0; i < ratings.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < ratings.length; j++) {

                if (ratings[j] < ratings[min])
                    min = j;
            }

            int temp = ratings[i];
            ratings[i] = ratings[min];
            ratings[min] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ratings = new int[n];

        for (int i = 0; i < n; i++)
            ratings[i] = sc.nextInt();

        selectionSort(ratings);

        for (int rating : ratings)
            System.out.print(rating + " ");

        sc.close();
    }
}