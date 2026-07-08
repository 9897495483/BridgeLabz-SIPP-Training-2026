import java.util.Scanner;

public class EmployeeAttendanceRanking {

    static void sortEmployees(int[] ids, int[] attendance) {

        int n = ids.length;

        for (int i = 0; i < n - 1; i++) {

            int max = i;

            for (int j = i + 1; j < n; j++) {

                if (attendance[j] > attendance[max] ||
                        (attendance[j] == attendance[max] && ids[j] < ids[max])) {

                    max = j;
                }
            }

            int temp = attendance[i];
            attendance[i] = attendance[max];
            attendance[max] = temp;

            temp = ids[i];
            ids[i] = ids[max];
            ids[max] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] employeeIds = new int[n];
        int[] attendance = new int[n];

        for (int i = 0; i < n; i++)
            employeeIds[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            attendance[i] = sc.nextInt();

        int k = sc.nextInt();

        sortEmployees(employeeIds, attendance);

        for (int i = 0; i < k; i++)
            System.out.print(employeeIds[i] + " ");

        sc.close();
    }
}