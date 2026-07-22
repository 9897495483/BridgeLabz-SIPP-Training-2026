import java.util.*;

public class DeliveryRouteFinder {

    private Map<Integer, List<Integer>> roadNetwork;

    public DeliveryRouteFinder() {
        roadNetwork = new HashMap<>();
    }

    public void addRoad(int sourceLocation, int destinationLocation) {

        roadNetwork
                .computeIfAbsent(sourceLocation, key -> new ArrayList<>())
                .add(destinationLocation);

        roadNetwork
                .computeIfAbsent(destinationLocation, key -> new ArrayList<>())
                .add(sourceLocation);
    }

    public List<List<Integer>> findAllRoutes(int sourceLocation,
                                             int destinationLocation) {

        List<List<Integer>> allRoutes = new ArrayList<>();

        List<Integer> currentRoute = new ArrayList<>();

        Set<Integer> visitedLocations = new HashSet<>();

        dfs(sourceLocation,
                destinationLocation,
                currentRoute,
                visitedLocations,
                allRoutes);

        return allRoutes;
    }

    private void dfs(int currentLocation,
                     int destinationLocation,
                     List<Integer> currentRoute,
                     Set<Integer> visitedLocations,
                     List<List<Integer>> allRoutes) {

        currentRoute.add(currentLocation);

        visitedLocations.add(currentLocation);

        if (currentLocation == destinationLocation) {

            allRoutes.add(new ArrayList<>(currentRoute));

        } else {

            for (int nextLocation :
                    roadNetwork.getOrDefault(currentLocation,
                            Collections.emptyList())) {

                if (!visitedLocations.contains(nextLocation)) {

                    dfs(nextLocation,
                            destinationLocation,
                            currentRoute,
                            visitedLocations,
                            allRoutes);
                }
            }
        }

        currentRoute.remove(currentRoute.size() - 1);

        visitedLocations.remove(currentLocation);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DeliveryRouteFinder deliveryNetwork =
                new DeliveryRouteFinder();

        System.out.print("Enter number of roads: ");
        int numberOfRoads = scanner.nextInt();

        System.out.println("Enter road connections:");

        for (int index = 0; index < numberOfRoads; index++) {

            int sourceLocation = scanner.nextInt();
            int destinationLocation = scanner.nextInt();

            deliveryNetwork.addRoad(sourceLocation,
                    destinationLocation);
        }

        System.out.print("Enter warehouse location: ");
        int warehouse = scanner.nextInt();

        System.out.print("Enter store location: ");
        int store = scanner.nextInt();

        List<List<Integer>> routes =
                deliveryNetwork.findAllRoutes(warehouse,
                        store);

        if (routes.isEmpty()) {

            System.out.println("No route found.");

        } else {

            System.out.println("All Possible Routes:");

            for (List<Integer> route : routes) {
                System.out.println(route);
            }
        }
    }
}