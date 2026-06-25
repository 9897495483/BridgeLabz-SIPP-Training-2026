import java.util.Scanner;
import java.time.LocalDate;

public class CalendarDisplay {

    public static String getMonthName(int month) {

        String[] months = {
                "", "January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "September", "October",
                "November", "December"
        };

        return months[month];
    }

    public static int getDaysInMonth(
            int month,
            int year) {

        int[] days = {
                0,31,28,31,30,31,30,
                31,31,30,31,30,31
        };

        if (month == 2 &&
                java.time.Year.isLeap(year))
            return 29;

        return days[month];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Month: ");
        int month = sc.nextInt();

        System.out.print("Year: ");
        int year = sc.nextInt();

        LocalDate date =
                LocalDate.of(year, month, 1);

        int firstDay =
                date.getDayOfWeek().getValue() % 7;

        int days =
                getDaysInMonth(month, year);

        System.out.println("\n"
                + getMonthName(month)
                + " " + year);

        System.out.println(
                "Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++)
            System.out.print("    ");

        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0)
                System.out.println();
        }

        sc.close();
    }
}