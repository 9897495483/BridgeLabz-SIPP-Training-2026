import java.io.*;

public class GroceryBillReader {
    public static void main(String[] args) {

        int lineCount = 0;

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("bill.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
                lineCount++;
            }

            br.close();

            System.out.println("\nTotal Lines = " + lineCount);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}