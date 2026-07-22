import java.util.*;

public class CircuitWiringCycleDetector {

    private Map<Integer, List<Integer>> circuitGraph;

    public CircuitWiringCycleDetector() {
        circuitGraph = new HashMap<>();
    }

    public void addConnection(int firstNode, int secondNode) {

        circuitGraph
                .computeIfAbsent(firstNode, key -> new ArrayList<>())
                .add(secondNode);

        circuitGraph
                .computeIfAbsent(secondNode, key -> new ArrayList<>())
                .add(firstNode);
    }

    public boolean hasCycle(int totalVertices) {

        Set<Integer> visitedVertices = new HashSet<>();

        for (int currentVertex = 0;
             currentVertex < totalVertices;
             currentVertex++) {

            if (!visitedVertices.contains(currentVertex)) {

                if (depthFirstSearch(currentVertex,
                        -1,
                        visitedVertices)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean depthFirstSearch(int currentVertex,
                                     int parentVertex,
                                     Set<Integer> visitedVertices) {

        visitedVertices.add(currentVertex);

        for (int adjacentVertex :
                circuitGraph.getOrDefault(currentVertex,
                        Collections.emptyList())) {

            if (!visitedVertices.contains(adjacentVertex)) {

                if (depthFirstSearch(adjacentVertex,
                        currentVertex,
                        visitedVertices)) {

                    return true;
                }

            } else if (adjacentVertex != parentVertex) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CircuitWiringCycleDetector circuit =
                new CircuitWiringCycleDetector();

        System.out.print("Enter total number of vertices: ");
        int totalVertices = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int totalEdges = scanner.nextInt();

        System.out.println("Enter edges:");

        for (int index = 0; index < totalEdges; index++) {

            int firstVertex = scanner.nextInt();
            int secondVertex = scanner.nextInt();

            circuit.addConnection(firstVertex, secondVertex);
        }

        if (circuit.hasCycle(totalVertices)) {

            System.out.println("Cycle detected in the circuit.");

        } else {

            System.out.println("No cycle detected.");
        }
    }
}