public class Subsets {

    static void subsets(int[] arr,
                        int index,
                        String current) {

        if (index == arr.length) {
            System.out.println("[" +
                    current.trim() + "]");
            return;
        }

        subsets(arr,
                index + 1,
                current);

        subsets(arr,
                index + 1,
                current + arr[index] + " ");
    }

    public static void main(String[] args) {

        int[] arr = {1, 2};

        subsets(arr, 0, "");
    }
}