import java.util.*;

public class TaskDependencyCycleDetector {

    private Map<Integer, List<Integer>> taskGraph;

    public TaskDependencyCycleDetector() {
        taskGraph = new HashMap<>();
    }

    public void addDependency(int prerequisiteTask,
                              int dependentTask) {

        taskGraph
                .computeIfAbsent(prerequisiteTask,
                        key -> new ArrayList<>())
                .add(dependentTask);
    }

    public boolean hasCycle(int totalTasks) {

        Set<Integer> visitedTasks = new HashSet<>();

        Set<Integer> recursionStack = new HashSet<>();

        for (int currentTask = 0;
             currentTask < totalTasks;
             currentTask++) {

            if (!visitedTasks.contains(currentTask)) {

                if (depthFirstSearch(currentTask,
                        visitedTasks,
                        recursionStack)) {

                    return true;
                }
            }
        }

        return false;
    }

    private boolean depthFirstSearch(int currentTask,
                                     Set<Integer> visitedTasks,
                                     Set<Integer> recursionStack) {

        visitedTasks.add(currentTask);

        recursionStack.add(currentTask);

        for (int nextTask :
                taskGraph.getOrDefault(currentTask,
                        Collections.emptyList())) {

            if (!visitedTasks.contains(nextTask)) {

                if (depthFirstSearch(nextTask,
                        visitedTasks,
                        recursionStack)) {

                    return true;
                }

            } else if (recursionStack.contains(nextTask)) {

                return true;
            }
        }

        recursionStack.remove(currentTask);

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskDependencyCycleDetector taskManager =
                new TaskDependencyCycleDetector();

        System.out.print("Enter total number of tasks: ");
        int totalTasks = scanner.nextInt();

        System.out.print("Enter number of dependencies: ");
        int totalDependencies = scanner.nextInt();

        System.out.println("Enter dependencies (A B means A must be completed before B):");

        for (int index = 0; index < totalDependencies; index++) {

            int prerequisiteTask = scanner.nextInt();
            int dependentTask = scanner.nextInt();

            taskManager.addDependency(prerequisiteTask,
                    dependentTask);
        }

        if (taskManager.hasCycle(totalTasks)) {

            System.out.println("Circular dependency detected.");

        } else {

            System.out.println("No circular dependency found.");
        }
    }
}