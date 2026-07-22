import java.util.*;

public class SensorReadingHeapSort {

    static void heapSort(int[] readings) {

        int size = readings.length;

        for (int index = size / 2 - 1;
             index >= 0;
             index--) {

            siftDown(readings, index, size);
        }

        for (int end = size - 1; end > 0; end--) {

            int temporary = readings[0];
            readings[0] = readings[end];
            readings[end] = temporary;

            siftDown(readings, 0, end);
        }
    }

    static void siftDown(int[] heap,
                         int currentIndex,
                         int heapSize) {

        int largest = currentIndex;

        int left = 2 * currentIndex + 1;
        int right = 2 * currentIndex + 2;

        if (left < heapSize &&
                heap[left] > heap[largest]) {

            largest = left;
        }

        if (right < heapSize &&
                heap[right] > heap[largest]) {

            largest = right;
        }

        if (largest != currentIndex) {

            int temporary = heap[currentIndex];
            heap[currentIndex] = heap[largest];
            heap[largest] = temporary;

            siftDown(heap, largest, heapSize);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] readings = new int[size];

        for (int index = 0; index < size; index++) {
            readings[index] = scanner.nextInt();
        }

        heapSort(readings);

        System.out.println(Arrays.toString(readings));
    }
}