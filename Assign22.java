import java.util.Scanner;

public class Assign22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input full name
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        // Compute initials
        String initials = computeInitials(fullName);

        // Display initials
        System.out.println("Initials: " + initials);
        scanner.close();
    }

    public static String computeInitials(String fullName) {
        StringBuilder initials = new StringBuilder();

        // Split the full name by spaces
        String[] parts = fullName.split("\\s+");

        // Iterate over the parts to get the last name and the initials of other names
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            // If it's the last part, append it as it is
            if (i == parts.length - 1) {
                initials.insert(0, part);
            } else {
                // Otherwise, append the first character followed by a dot
                initials.insert(0, part.charAt(0) + ".");
            }
            // Add a space if it's not the last part
            if (i < parts.length - 1) {
                initials.insert(0, " ");
            }
        }

        return initials.toString();
    }
}
