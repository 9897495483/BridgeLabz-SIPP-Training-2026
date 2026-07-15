import java.util.*;

public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String text) {

        Deque<Character> characterStack = new ArrayDeque<>();

        for (char currentCharacter : text.toCharArray()) {

            if (!characterStack.isEmpty() &&
                characterStack.peek() == currentCharacter) {

                characterStack.pop();
            } else {
                characterStack.push(currentCharacter);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.println("After removing duplicates: " + removeDuplicates(text));

        scanner.close();
    }
}