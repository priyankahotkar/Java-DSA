import java.util.Scanner;

public class Palindromicpattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n ; i++) {
            for (int j = 1; j<=(n-i) ; j++) {
                System.out.print("  ");
            }
            int num = i;
            for (int j = 1; j<=i ; j++) {
                System.out.print(num+" ");
                num--;
            }
            int nm = 2;
            for(int j = 1; j<i;j++) {
                System.out.print(nm+" ");
                nm++;
            }
            System.out.println();
        }
        sc.close();
    }
}
