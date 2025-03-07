package calc;

import java.util.Scanner;

public class ScCalculator {
    public void m2() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a*b);
        sc.close();
    }
}
