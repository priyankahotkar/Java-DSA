import java.util.*;
public class Sum {
    public static void main(String[] args) {
        System.out.println("Enter any 2 numbers : ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a+b;
        System.out.print("The sum of these 2 numbers is : ");
        System.out.println(sum);
        sc.close();
    }
}
