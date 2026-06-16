import java.util.Scanner;

public class FrequencyUnique {

    static char[] uniqueChars(String text) {

        char[] temp = new char[text.length()];
        int k = 0;

        for(int i=0;i<text.length();i++) {

            boolean found = false;

            for(int j=0;j<k;j++) {

                if(temp[j] == text.charAt(i)) {
                    found = true;
                    break;
                }
            }

            if(!found)
                temp[k++] = text.charAt(i);
        }

        char[] unique = new char[k];

        for(int i=0;i<k;i++)
            unique[i] = temp[i];

        return unique;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        char[] unique = uniqueChars(text);

        System.out.println("Char\tFreq");

        for(char ch : unique) {

            int count = 0;

            for(int i=0;i<text.length();i++) {

                if(text.charAt(i)==ch)
                    count++;
            }

            System.out.println(ch + "\t" + count);
        }

        sc.close();
    }
}