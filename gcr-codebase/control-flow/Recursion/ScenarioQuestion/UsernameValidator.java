public class UsernameValidator {

    static boolean isValid(String username, int index) {

        if (index == username.length())
            return true;

        char ch = username.charAt(index);

        if (ch < 'a' || ch > 'z')
            return false;

        return isValid(username, index + 1);
    }

    public static void main(String[] args) {

        String username = "abcdxyz";

        System.out.println(
                isValid(username, 0));
    }
}