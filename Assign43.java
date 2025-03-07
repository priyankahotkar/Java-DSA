import java.util.Scanner;

public class Assign43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int deci = 0;
        int x = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            int a = s.charAt(i) - '0';
            deci += a*x;
            x *= 2;
        }
        System.out.println(deci);
        String hexString = Integer.toHexString(deci);
        System.out.println(hexString.toUpperCase());
        sc.close();
    }
}
