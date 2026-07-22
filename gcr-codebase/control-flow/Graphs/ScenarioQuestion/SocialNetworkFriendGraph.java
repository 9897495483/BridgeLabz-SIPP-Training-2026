import java.util.*;

public class SocialNetworkFriendGraph {

    private Map<Integer, Set<Integer>> friendGraph;

    public SocialNetworkFriendGraph() {
        friendGraph = new HashMap<>();
    }

    public void addFriendship(int firstUser, int secondUser) {

        friendGraph
                .computeIfAbsent(firstUser, key -> new HashSet<>())
                .add(secondUser);

        friendGraph
                .computeIfAbsent(secondUser, key -> new HashSet<>())
                .add(firstUser);
    }

    public boolean areFriends(int firstUser, int secondUser) {

        return friendGraph
                .getOrDefault(firstUser, Collections.emptySet())
                .contains(secondUser);
    }

    public void displayFriendGraph() {

        System.out.println("\nFriend Graph:");

        for (Map.Entry<Integer, Set<Integer>> entry : friendGraph.entrySet()) {

            System.out.println(
                    "User " + entry.getKey() + " -> " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SocialNetworkFriendGraph socialNetwork =
                new SocialNetworkFriendGraph();

        System.out.print("Enter number of friendships: ");
        int friendshipCount = scanner.nextInt();

        System.out.println("Enter friendship pairs:");

        for (int index = 0; index < friendshipCount; index++) {

            int firstUser = scanner.nextInt();
            int secondUser = scanner.nextInt();

            socialNetwork.addFriendship(firstUser, secondUser);
        }

        socialNetwork.displayFriendGraph();

        System.out.print("\nEnter first user to check friendship: ");
        int firstUser = scanner.nextInt();

        System.out.print("Enter second user to check friendship: ");
        int secondUser = scanner.nextInt();

        if (socialNetwork.areFriends(firstUser, secondUser)) {
            System.out.println("They are friends.");
        } else {
            System.out.println("They are not friends.");
        }
    }
}