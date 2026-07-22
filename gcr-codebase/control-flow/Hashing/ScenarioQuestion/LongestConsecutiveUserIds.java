import java.util.*;

public class LongestConsecutiveUserIds {

    public static int findLongestConsecutiveRun(int[] userIds) {

        Set<Integer> uniqueUserIds = new HashSet<>();

        for (int id : userIds) {
            uniqueUserIds.add(id);
        }

        int longestRunLength = 0;

        for (int id : uniqueUserIds) {

            if (!uniqueUserIds.contains(id - 1)) {

                int currentId = id;
                int currentRunLength = 1;

                while (uniqueUserIds.contains(currentId + 1)) {

                    currentId++;
                    currentRunLength++;
                }

                longestRunLength = Math.max(longestRunLength, currentRunLength);
            }
        }

        return longestRunLength;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of user IDs: ");
        int size = scanner.nextInt();

        int[] userIds = new int[size];

        System.out.println("Enter user IDs:");

        for (int index = 0; index < size; index++) {
            userIds[index] = scanner.nextInt();
        }

        System.out.println(findLongestConsecutiveRun(userIds));
    }
}