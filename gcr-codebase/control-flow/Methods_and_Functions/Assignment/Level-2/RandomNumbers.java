import java.util.Arrays;

public class RandomNumbers {

    public static int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }

        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;

        for (int num : numbers) {

            sum += num;

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double avg = sum / numbers.length;

        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {

        int[] numbers = generate4DigitRandomArray(5);

        System.out.println("Generated Numbers:");
        System.out.println(Arrays.toString(numbers));

        double[] result = findAverageMinMax(numbers);

        System.out.println("Average = " + result[0]);
        System.out.println("Minimum = " + (int)result[1]);
        System.out.println("Maximum = " + (int)result[2]);
    }
}