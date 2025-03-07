import java.util.Calendar;

public class DateTime {
    public static void main(String[] args) {
        // Assuming date, month, and year are given
        int year = 2024;
        int month = 2; // February (Note: January is 0, February is 1, and so on)
        int dayOfMonth = 19;

        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Set the year, month, and day of the month
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Month is 0-based index
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        // Get the day of the month
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Print the day of the month
        System.out.println("Day of the month: " + day);
    }
}
