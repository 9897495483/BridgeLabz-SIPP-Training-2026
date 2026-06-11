import java.util.Scanner;

public class TableSixToNine {

    static void generateTable(int num) {

        int[] result = new int[4];

        int index = 0;

        for (int i = 6; i <= 9; i++) {
            result[index++] = num * i;
        }

        index = 0;

        for (int i = 6; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + result[index++]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        generateTable(num);
    }
}