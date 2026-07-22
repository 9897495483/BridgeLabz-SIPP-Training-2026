import java.util.*;

public class DuplicateSessionTokenDetection {

    public static boolean hasDuplicateToken(String[] sessionTokens) {
        Set<String> seenTokens = new HashSet<>();

        for (String token : sessionTokens) {
            if (!seenTokens.add(token)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of session tokens: ");
        int numberOfTokens = scanner.nextInt();
        scanner.nextLine();

        String[] sessionTokens = new String[numberOfTokens];

        System.out.println("Enter session tokens:");

        for (int index = 0; index < numberOfTokens; index++) {
            sessionTokens[index] = scanner.nextLine();
        }

        System.out.println(hasDuplicateToken(sessionTokens));
    }
}