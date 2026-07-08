import java.util.Scanner;

public class EmployeeIdInsertionSorter {

    static void insertionSort(int[] ids) {

        for (int i = 1; i < ids.length; i++) {

            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {

                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] employeeIds = new int[n];

        for (int i = 0; i < n; i++)
            employeeIds[i] = sc.nextInt();

        insertionSort(employeeIds);

        for (int id : employeeIds)
            System.out.print(id + " ");

        sc.close();
    }
}