import java.util.*;

public class MostFrequentErrorCode {

    public static int findMostFrequentErrorCode(int[] errorCodes) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int mostFrequentCode = errorCodes[0];
        int highestFrequency = 0;

        for (int code : errorCodes) {

            int currentFrequency = frequencyMap.getOrDefault(code, 0) + 1;
            frequencyMap.put(code, currentFrequency);

            if (currentFrequency > highestFrequency) {
                highestFrequency = currentFrequency;
                mostFrequentCode = code;
            }
        }

        return mostFrequentCode;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of error codes: ");
        int size = scanner.nextInt();

        int[] errorCodes = new int[size];

        System.out.println("Enter error codes:");

        for (int index = 0; index < size; index++) {
            errorCodes[index] = scanner.nextInt();
        }

        System.out.println(findMostFrequentErrorCode(errorCodes));
    }
}