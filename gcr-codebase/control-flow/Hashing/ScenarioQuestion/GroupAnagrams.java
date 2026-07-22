import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagramStrings(String[] words) {

        Map<String, List<String>> groupedWords = new HashMap<>();

        for (String word : words) {

            char[] characters = word.toCharArray();
            Arrays.sort(characters);

            String sortedWord = new String(characters);

            groupedWords
                    .computeIfAbsent(sortedWord, key -> new ArrayList<>())
                    .add(word);
        }

        return new ArrayList<>(groupedWords.values());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[size];

        System.out.println("Enter words:");

        for (int index = 0; index < size; index++) {
            words[index] = scanner.nextLine();
        }

        System.out.println(groupAnagramStrings(words));
    }
}