import java.util.*;
public class Conditional {
    public static void main(String[] args) {
        System.out.print("Enter 2 numbers : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a==b) {
            System.out.println("Equal");
        }
        else if (a>b) {
            System.out.println("a is greater than b");
        }
        else {
            System.out.println("a is smaller than b");
        }
        sc.close();
    }
}
