import java.util.Scanner;

public class BitmanipulationHW4 {
    public static void decimalTobinary (int n) {
        StringBuilder sb = new StringBuilder("");
        while (n>0) {
            sb.append(Integer.toString(n%2));
            n = n/2;
        }
        sb.reverse();
        System.out.println(sb);
    }
    public static void binaryToDecimal(int binary) {
        int power = 0;
        int ans = 0;
        int x;
        while (binary > 0) {
            x = binary%10;
            ans += x*(Math.pow(2,power));
            power++;
            binary /= 10;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        binaryToDecimal(n);

        sc.close();
    }
}
