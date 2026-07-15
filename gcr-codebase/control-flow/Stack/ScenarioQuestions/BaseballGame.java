import java.util.*;

public class BaseballGame {

    public static int calculateScore(String[] operations) {

        Deque<Integer> scoreStack = new ArrayDeque<>();

        for (String operation : operations) {

            if (operation.equals("+")) {

                int firstScore = scoreStack.pop();
                int secondScore = scoreStack.peek();

                scoreStack.push(firstScore);
                scoreStack.push(firstScore + secondScore);

            } else if (operation.equals("D")) {

                scoreStack.push(scoreStack.peek() * 2);

            } else if (operation.equals("C")) {

                scoreStack.pop();

            } else {

                scoreStack.push(Integer.parseInt(operation));
            }
        }

        int totalScore = 0;

        while (!scoreStack.isEmpty()) {
            totalScore += scoreStack.pop();
        }

        return totalScore;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of operations: ");
        int numberOfOperations = scanner.nextInt();

        scanner.nextLine();

        String[] operations = new String[numberOfOperations];

        System.out.println("Enter operations:");

        for (int index = 0; index < numberOfOperations; index++) {
            operations[index] = scanner.next();
        }

        System.out.println("Final Score = " + calculateScore(operations));

        scanner.close();
    }
}