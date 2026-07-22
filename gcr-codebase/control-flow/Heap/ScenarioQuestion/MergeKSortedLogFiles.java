import java.util.*;

class HeapNode {

    int listIndex;
    int elementIndex;
    int value;

    HeapNode(int listIndex,
             int elementIndex,
             int value) {

        this.listIndex = listIndex;
        this.elementIndex = elementIndex;
        this.value = value;
    }
}

public class MergeKSortedLogFiles {

    static List<Integer> mergeSortedLists(List<List<Integer>> sortedLists) {

        PriorityQueue<HeapNode> minimumHeap =
                new PriorityQueue<>(
                        Comparator.comparingInt(node -> node.value));

        for (int list = 0; list < sortedLists.size(); list++) {

            if (!sortedLists.get(list).isEmpty()) {

                minimumHeap.offer(
                        new HeapNode(list,
                                0,
                                sortedLists.get(list).get(0)));
            }
        }

        List<Integer> mergedList =
                new ArrayList<>();

        while (!minimumHeap.isEmpty()) {

            HeapNode current =
                    minimumHeap.poll();

            mergedList.add(current.value);

            if (current.elementIndex + 1 <
                    sortedLists.get(current.listIndex).size()) {

                minimumHeap.offer(
                        new HeapNode(
                                current.listIndex,
                                current.elementIndex + 1,
                                sortedLists.get(current.listIndex)
                                        .get(current.elementIndex + 1)
                        )
                );
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLists = scanner.nextInt();

        List<List<Integer>> sortedLists =
                new ArrayList<>();

        for (int list = 0; list < numberOfLists; list++) {

            int size = scanner.nextInt();

            List<Integer> currentList =
                    new ArrayList<>();

            for (int index = 0; index < size; index++) {

                currentList.add(scanner.nextInt());
            }

            sortedLists.add(currentList);
        }

        System.out.println(
                mergeSortedLists(sortedLists));
    }
}