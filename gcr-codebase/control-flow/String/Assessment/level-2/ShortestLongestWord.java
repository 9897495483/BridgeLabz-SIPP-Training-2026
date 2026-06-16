import java.util.Scanner;

public class ShortestLongestWord {

    public static String[] splitWords(String text) {
        return text.split(" ");
    }

    public static int[] findShortestLongest(String[] words) {

        int shortest = 0;
        int longest = 0;

        for (int i = 1; i < words.length; i++) {

            if (words[i].length() < words[shortest].length())
                shortest = i;

            if (words[i].length() > words[longest].length())
                longest = i;
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);

        int[] result = findShortestLongest(words);

        System.out.println("Shortest Word = " +
                words[result[0]]);

        System.out.println("Longest Word = " +
                words[result[1]]);

        sc.close();
    }
}