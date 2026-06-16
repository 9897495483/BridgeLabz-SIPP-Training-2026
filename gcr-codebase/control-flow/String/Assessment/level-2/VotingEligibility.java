import java.util.Scanner;

public class VotingEligibility {

    static int[] createAges(int n) {

        int[] ages = new int[n];

        for(int i=0;i<n;i++)
            ages[i]=(int)(Math.random()*90)+1;

        return ages;
    }

    static String[][] checkVote(int[] ages) {

        String[][] result =
                new String[ages.length][2];

        for(int i=0;i<ages.length;i++) {

            result[i][0] =
                    String.valueOf(ages[i]);

            if(ages[i] >= 18)
                result[i][1] = "true";
            else
                result[i][1] = "false";
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Students: ");
        int n = sc.nextInt();

        int[] ages = createAges(n);

        String[][] result = checkVote(ages);

        System.out.println("Age\tCanVote");

        for(int i=0;i<n;i++) {
            System.out.println(result[i][0]
                    + "\t" + result[i][1]);
        }

        sc.close();
    }
}