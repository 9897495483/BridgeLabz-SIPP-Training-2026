import java.util.Scanner;

public class PatientRegistrationSorter {

    static void merge(int[] arr, int left, int mid, int right) {

        int[] leftPart = new int[mid - left + 1];
        int[] rightPart = new int[right - mid];

        for (int i = 0; i < leftPart.length; i++)
            leftPart[i] = arr[left + i];

        for (int i = 0; i < rightPart.length; i++)
            rightPart[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < leftPart.length && j < rightPart.length) {

            if (leftPart[i] <= rightPart[j])
                arr[k++] = leftPart[i++];
            else
                arr[k++] = rightPart[j++];
        }

        while (i < leftPart.length)
            arr[k++] = leftPart[i++];

        while (j < rightPart.length)
            arr[k++] = rightPart[j++];
    }

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();

        int[] patientIds = new int[n];

        System.out.println("Enter patient IDs:");

        for (int i = 0; i < n; i++)
            patientIds[i] = sc.nextInt();

        mergeSort(patientIds, 0, n - 1);

        System.out.println("Sorted Patient IDs:");

        for (int id : patientIds)
            System.out.print(id + " ");

        sc.close();
    }
}