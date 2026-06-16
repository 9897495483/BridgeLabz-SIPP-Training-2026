import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {

        int n = (int)(Math.random()*3);

        if(n==0) return "Rock";
        if(n==1) return "Paper";

        return "Scissors";
    }

    static String winner(String user,
                         String computer) {

        if(user.equals(computer))
            return "Draw";

        if((user.equals("Rock")
                && computer.equals("Scissors"))
                ||
                (user.equals("Paper")
                        && computer.equals("Rock"))
                ||
                (user.equals("Scissors")
                        && computer.equals("Paper")))
            return "User";

        return "Computer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userWin=0;
        int computerWin=0;

        System.out.print("Games = ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {

            System.out.print(
                    "Rock/Paper/Scissors : ");

            String user = sc.next();

            String computer =
                    computerChoice();

            String result =
                    winner(user,computer);

            System.out.println(
                    "Computer = " + computer);

            System.out.println(
                    "Winner = " + result);

            if(result.equals("User"))
                userWin++;

            else if(result.equals("Computer"))
                computerWin++;
        }

        System.out.println("\nUser Wins = "
                + userWin);

        System.out.println(
                "Computer Wins = "
                        + computerWin);

        System.out.println(
                "User % = "
                        + (userWin*100.0/n));

        System.out.println(
                "Computer % = "
                        + (computerWin*100.0/n));

        sc.close();
    }
}