import java.util.*;
public class Loopspractice {
    public static void main(String[] args) {
        do {
            System.out.print("Enter 0 or 1 : ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Enter marks: ");
                int m = sc.nextInt();
                if (m >= 90) {
                    System.out.println("This is good");
                }
                else if (m>=60 && m<=89) {
                    System.out.println("This is also good");
                }
                else if (m>=0 && m<=59) {
                    System.out.println("This is good as well");
                }
                else {
                    System.out.println("Invalid marks");
                }
            } else {
                break;
            }
            sc.close();
        } while(true);
        
    }
}
