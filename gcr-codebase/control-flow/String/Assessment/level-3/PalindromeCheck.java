import java.util.Scanner;

public class PalindromeCheck {

    static boolean method1(String text) {

        int start = 0;
        int end = text.length()-1;

        while(start < end) {

            if(text.charAt(start) != text.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    static boolean method2(String text,int start,int end) {

        if(start >= end)
            return true;

        if(text.charAt(start)!=text.charAt(end))
            return false;

        return method2(text,start+1,end-1);
    }

    static String reverse(String text) {

        String rev="";

        for(int i=text.length()-1;i>=0;i--)
            rev+=text.charAt(i);

        return rev;
    }

    static boolean method3(String text) {
        return text.equals(reverse(text));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        System.out.println("Method1 : " + method1(text));
        System.out.println("Method2 : " +
                method2(text,0,text.length()-1));
        System.out.println("Method3 : " + method3(text));

        sc.close();
    }
}