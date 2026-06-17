public class Permutations {

    static void permutation(String str,
                            String ans) {

        if (str.length() == 0) {

            System.out.println(ans);
            return;
        }

        for (int i = 0;
             i < str.length();
             i++) {

            char ch = str.charAt(i);

            String left =
                    str.substring(0, i);

            String right =
                    str.substring(i + 1);

            permutation(
                    left + right,
                    ans + ch);
        }
    }

    public static void main(String[] args) {

        permutation("ABC", "");
    }
}