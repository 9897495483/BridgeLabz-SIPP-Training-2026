import java.util.Scanner;

public class DeckCards {

    static String[] initializeDeck() {

        String[] suits =
                {"Hearts","Diamonds","Clubs","Spades"};

        String[] ranks =
                {"2","3","4","5","6","7","8",
                        "9","10","Jack","Queen",
                        "King","Ace"};

        String[] deck = new String[52];

        int index = 0;

        for(String suit : suits) {

            for(String rank : ranks) {

                deck[index++] =
                        rank + " of " + suit;
            }
        }

        return deck;
    }

    static void shuffle(String[] deck) {

        int n = deck.length;

        for(int i=0;i<n;i++) {

            int random =
                    i+(int)(Math.random()*(n-i));

            String temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Players : ");
        int players = sc.nextInt();

        System.out.print("Cards per Player : ");
        int cards = sc.nextInt();

        if(players*cards > 52) {

            System.out.println(
                    "Cannot distribute cards");

            return;
        }

        String[] deck = initializeDeck();

        shuffle(deck);

        int index = 0;

        for(int i=0;i<players;i++) {

            System.out.println(
                    "\nPlayer " + (i+1));

            for(int j=0;j<cards;j++) {

                System.out.println(
                        deck[index++]);
            }
        }

        sc.close();
    }
}