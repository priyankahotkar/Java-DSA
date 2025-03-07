import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AadharPhoneNumberMapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        // Read existing records from file
        // No need for storing in a Map, we'll just search directly
        // We'll use a boolean flag to indicate if the record is found
        boolean recordFound = false;

        // Get Aadhar card number from user
        System.out.print("Enter Aadhar card number: ");
        String aadharNumber = scanner.nextLine();
        scanner.close();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\n");
                if (parts.length == 2 && parts[0].equalsIgnoreCase(aadharNumber)) {
                    System.out.println("Phone number linked with Aadhar card number " + aadharNumber + " is: " + parts[1]);
                    recordFound = true;
                    break; // No need to continue searching if the record is found
                }
            }
            if (!recordFound) {
                System.out.println("Record does not exist.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
