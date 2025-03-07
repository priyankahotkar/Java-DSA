import java.util.Scanner;

public class Assign42 {
    public static boolean ispalindrome (String number , int index) {
        if (index == number.length()-1) {
            return true;
        }
        if (number.charAt(index) == number.charAt(number.length()-1-index)) {
            return ispalindrome(number, index+1);
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String number = Integer.toString(n);
        if (ispalindrome(number, 0))
            System.out.println("Number is a palindrome");
        else 
            System.out.println("Number is not a palindrome");
        sc.close();
    }
}
