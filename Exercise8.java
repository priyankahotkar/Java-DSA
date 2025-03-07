import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base : ");
        int x = sc.nextInt();
        System.out.print("Enter exponent : ");
        int n = sc.nextInt();
        int ans = 1;
        for(int i=1;i<=n;i++)
            ans = ans*x;
        System.out.println(ans);
        sc.close();
    }
}
