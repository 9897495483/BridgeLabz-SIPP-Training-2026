import java.util.*;

public class ShipmentPriorityHeapBuilder {

    static void buildMinHeap(int[] shipmentPriorities) {

        int numberOfShipments = shipmentPriorities.length;

        for (int currentIndex = numberOfShipments / 2 - 1;
             currentIndex >= 0;
             currentIndex--) {

            siftDown(shipmentPriorities,
                    currentIndex,
                    numberOfShipments);
        }
    }

    static void siftDown(int[] heap,
                         int currentIndex,
                         int heapSize) {

        int smallestIndex = currentIndex;

        int leftChild = 2 * currentIndex + 1;
        int rightChild = 2 * currentIndex + 2;

        if (leftChild < heapSize &&
                heap[leftChild] < heap[smallestIndex]) {

            smallestIndex = leftChild;
        }

        if (rightChild < heapSize &&
                heap[rightChild] < heap[smallestIndex]) {

            smallestIndex = rightChild;
        }

        if (smallestIndex != currentIndex) {

            int temporary = heap[currentIndex];
            heap[currentIndex] = heap[smallestIndex];
            heap[smallestIndex] = temporary;

            siftDown(heap, smallestIndex, heapSize);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] priorities = new int[size];

        for (int index = 0; index < size; index++) {
            priorities[index] = scanner.nextInt();
        }

        buildMinHeap(priorities);

        System.out.println(Arrays.toString(priorities));
    }
}