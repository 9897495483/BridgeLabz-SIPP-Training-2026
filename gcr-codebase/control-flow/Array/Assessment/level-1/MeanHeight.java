import java.util.Scanner;

public class MeanHeight {

    static double findMean(double[] heights) {

        double sum = 0;

        for (double h : heights) {
            sum += h;
        }

        return sum / heights.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];

        for (int i = 0; i < 11; i++) {
            heights[i] = sc.nextDouble();
        }

        System.out.println("Mean Height = " + findMean(heights));
    }
}