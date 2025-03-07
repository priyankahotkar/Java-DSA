package calc;
import java.util.Scanner;

public class Calculator {
    public void m1() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(x+y);
        sc.close();
    }
}
