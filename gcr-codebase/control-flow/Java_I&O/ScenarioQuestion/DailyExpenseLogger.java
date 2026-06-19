import java.io.*;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            FileWriter fw =
                    new FileWriter("expenses.txt", true);

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            fw.write(category + " - " + amount);
            fw.write("\n");

            fw.close();

            System.out.println("Expense saved.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}