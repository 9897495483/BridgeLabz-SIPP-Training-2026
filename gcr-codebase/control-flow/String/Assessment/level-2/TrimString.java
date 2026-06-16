import java.util.Scanner;

public class TrimString {

    static int[] trimIndexes(String str) {

        int start = 0;
        int end = str.length()-1;

        while(start < str.length() &&
                str.charAt(start)==' ')
            start++;

        while(end >=0 &&
                str.charAt(end)==' ')
            end--;

        return new int[]{start,end};
    }

    static String substring(String str,
                            int start,
                            int end) {

        String result = "";

        for(int i=start;i<=end;i++)
            result += str.charAt(i);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] arr = trimIndexes(text);

        String user =
                substring(text,arr[0],arr[1]);

        String builtin = text.trim();

        System.out.println("User Trim = " + user);
        System.out.println("BuiltIn Trim = " + builtin);

        System.out.println(user.equals(builtin));

        sc.close();
    }
}