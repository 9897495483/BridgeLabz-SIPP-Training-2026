import java.util.Scanner;

public class SplitText {

    public static String[] splitWords(String text) {

        int words = 1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] arr = new String[words];

        int start = 0;
        int index = 0;

        for (int i = 0; i <= text.length(); i++) {

            if (i == text.length() || text.charAt(i) == ' ') {
                arr[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        return arr;
    }

    public static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        String[] user = splitWords(text);
        String[] builtin = text.split(" ");

        System.out.println("Same = " + compareArrays(user, builtin));

        sc.close();
    }
}