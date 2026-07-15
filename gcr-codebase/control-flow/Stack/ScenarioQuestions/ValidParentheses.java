import java.util.*;

public class ValidParentheses {

    public static boolean isValid(String expression) {

        Deque<Character> bracketStack = new ArrayDeque<>();

        for (char currentCharacter : expression.toCharArray()) {

            if (currentCharacter == '(' ||
                currentCharacter == '[' ||
                currentCharacter == '{') {

                bracketStack.push(currentCharacter);
            } else {

                if (bracketStack.isEmpty()) {
                    return false;
                }

                char openingBracket = bracketStack.pop();

                if (currentCharacter == ')' && openingBracket != '(')
                    return false;

                if (currentCharacter == ']' && openingBracket != '[')
                    return false;

                if (currentCharacter == '}' && openingBracket != '{')
                    return false;
            }
        }

        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the expression: ");
        String expression = scanner.nextLine();

        if (isValid(expression)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        scanner.close();
    }
}