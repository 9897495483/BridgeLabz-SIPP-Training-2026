import java.util.*;

public class CompanyNetworkConnectivityChecker {

    private Map<Integer, List<Integer>> companyNetwork;

    public CompanyNetworkConnectivityChecker() {
        companyNetwork = new HashMap<>();
    }

    public void addConnection(int firstServer, int secondServer) {

        companyNetwork
                .computeIfAbsent(firstServer, key -> new ArrayList<>())
                .add(secondServer);

        companyNetwork
                .computeIfAbsent(secondServer, key -> new ArrayList<>())
                .add(firstServer);
    }

    public int countNetworkSegments(int totalServers) {

        Set<Integer> visitedServers = new HashSet<>();

        int numberOfSegments = 0;

        for (int server = 0; server < totalServers; server++) {

            if (!visitedServers.contains(server)) {

                numberOfSegments++;

                depthFirstSearch(server, visitedServers);
            }
        }

        return numberOfSegments;
    }

    private void depthFirstSearch(int currentServer,
                                  Set<Integer> visitedServers) {

        visitedServers.add(currentServer);

        for (int connectedServer :
                companyNetwork.getOrDefault(currentServer,
                        Collections.emptyList())) {

            if (!visitedServers.contains(connectedServer)) {

                depthFirstSearch(connectedServer,
                        visitedServers);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CompanyNetworkConnectivityChecker network =
                new CompanyNetworkConnectivityChecker();

        System.out.print("Enter total number of servers: ");
        int totalServers = scanner.nextInt();

        System.out.print("Enter number of connections: ");
        int numberOfConnections = scanner.nextInt();

        System.out.println("Enter server connections:");

        for (int index = 0; index < numberOfConnections; index++) {

            int firstServer = scanner.nextInt();
            int secondServer = scanner.nextInt();

            network.addConnection(firstServer, secondServer);
        }

        int segments =
                network.countNetworkSegments(totalServers);

        System.out.println("\nNumber of Network Segments: "
                + segments);

        if (segments == 1) {
            System.out.println("The network is fully connected.");
        } else {
            System.out.println("The network is NOT fully connected.");
        }
    }
}