import java.util.Scanner;

public class FirstNonRepeating {

    static char firstNonRepeating(String text) {

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {

            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        char result = firstNonRepeating(text);

        if (result == '\0')
            System.out.println("No Non-Repeating Character");
        else
            System.out.println("First Non-Repeating Character = " + result);

        sc.close();
    }
}