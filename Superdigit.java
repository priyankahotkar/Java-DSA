import java.util.Scanner;

public class Superdigit {
    // Function to calculate the super digit of a number
    public static int superDigit(int n) {
        // If n has only one digit, return n
        if (n < 10) {
            return n;
        }
            
        // Calculate the sum of digits
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
            
        // Recursively calculate super digit of the sum
        return superDigit(sum);
    }
        
    public static void main(String[] args) {
        // Example usage
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int k = sc.nextInt();
        int superDigitResult = superDigit(number);
        System.out.println("Super digit of " + number + " is: " + superDigitResult);
        }
    }
    

