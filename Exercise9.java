import java.util.Scanner;

public class Exercise9 {
    public static int greater(int x , int y) {
        if (x>y)
            return x;
        else
            return y;
    }
    public static void main(String[] args) {
        int x,y;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a<b) {
            for(int i = 1;i<=a;i++) {
                if (a%i == 0 && b%i==0) {
                    x=i;
                }
            }
        }
        else if (a>b) {
            for(int i = 1;i<=b;i++) {
                if (a%i == 0 && b%i==0) {
                    
                }
            }
        }    
        else 
            System.out.println(a); 
        sc.close();
    }
}
