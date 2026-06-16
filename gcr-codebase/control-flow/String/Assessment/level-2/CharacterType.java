import java.util.Scanner;

public class CharacterType {

    static String checkChar(char ch) {

        if(ch >= 'A' && ch <= 'Z')
            ch = (char)(ch + 32);

        if(ch >= 'a' && ch <= 'z') {

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                return "Vowel";

            return "Consonant";
        }

        return "Not Letter";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        System.out.println("Character\tType");

        for(int i=0;i<text.length();i++) {

            System.out.println(text.charAt(i) + "\t\t"
                    + checkChar(text.charAt(i)));
        }

        sc.close();
    }
}