import java.util.*;

public class FlightRouteFinder {

    private Map<Integer, List<Integer>> flightRoutes;

    public FlightRouteFinder() {
        flightRoutes = new HashMap<>();
    }

    public void addFlight(int sourceCity, int destinationCity) {

        flightRoutes
                .computeIfAbsent(sourceCity, key -> new ArrayList<>())
                .add(destinationCity);

        flightRoutes
                .computeIfAbsent(destinationCity, key -> new ArrayList<>())
                .add(sourceCity);
    }

    public List<Integer> findShortestRoute(int sourceCity,
                                           int destinationCity) {

        Queue<Integer> cityQueue = new LinkedList<>();

        Set<Integer> visitedCities = new HashSet<>();

        Map<Integer, Integer> parentCity = new HashMap<>();

        cityQueue.offer(sourceCity);
        visitedCities.add(sourceCity);
        parentCity.put(sourceCity, null);

        while (!cityQueue.isEmpty()) {

            int currentCity = cityQueue.poll();

            if (currentCity == destinationCity) {
                break;
            }

            for (int nextCity :
                    flightRoutes.getOrDefault(currentCity,
                            Collections.emptyList())) {

                if (!visitedCities.contains(nextCity)) {

                    visitedCities.add(nextCity);

                    parentCity.put(nextCity, currentCity);

                    cityQueue.offer(nextCity);
                }
            }
        }

        if (!visitedCities.contains(destinationCity)) {
            return new ArrayList<>();
        }

        LinkedList<Integer> shortestRoute = new LinkedList<>();

        Integer currentCity = destinationCity;

        while (currentCity != null) {

            shortestRoute.addFirst(currentCity);

            currentCity = parentCity.get(currentCity);
        }

        return shortestRoute;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FlightRouteFinder flightNetwork = new FlightRouteFinder();

        System.out.print("Enter number of direct flights: ");
        int numberOfFlights = scanner.nextInt();

        System.out.println("Enter direct flight connections:");

        for (int index = 0; index < numberOfFlights; index++) {

            int sourceCity = scanner.nextInt();
            int destinationCity = scanner.nextInt();

            flightNetwork.addFlight(sourceCity, destinationCity);
        }

        System.out.print("Enter source city: ");
        int sourceCity = scanner.nextInt();

        System.out.print("Enter destination city: ");
        int destinationCity = scanner.nextInt();

        List<Integer> shortestRoute =
                flightNetwork.findShortestRoute(sourceCity,
                        destinationCity);

        if (shortestRoute.isEmpty()) {
            System.out.println("No route exists.");
        } else {
            System.out.println("Shortest Route: " + shortestRoute);
            System.out.println("Number of Flights: "
                    + (shortestRoute.size() - 1));
        }
    }
}