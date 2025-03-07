import java.util.Scanner;

public class UserValidation {
    
    // Validate email
    public static boolean isValidEmail(String email) {
        // Check if email contains '@' and '.'
        //return email.contains("@") && email.contains(".");
        return email.endsWith("@gmail.com");
    }
    
    // Validate username
    public static boolean isValidUsername(String username) {
        // Check if username length is between 5 and 20 characters
        return username.length() >= 5 && username.length() <= 20;
    }
    
    // Validate password
    public static boolean isValidPassword(String password) {
        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }
        
        // Check if password contains at least one uppercase letter, one lowercase letter, and one digit
        boolean hasUppercase = false, hasLowercase = false, hasDigit = false;
        for (int i = 0; i<password.length();i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        
        return hasUppercase && hasLowercase && hasDigit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get email from user input
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        System.out.println("Email is valid: " + isValidEmail(email));
        
        // Get username from user input
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Username is valid: " + isValidUsername(username));
        
        // Get password from user input
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Password is valid: " + isValidPassword(password));
        
        scanner.close();
    }
}
