import java.util.Scanner;
public class Assign1 {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter 2 numbers or enter -1 to stop : ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int i = a; i <= b; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            if (a == -1 && b == -1) {
                break;
            }
        }
    }
}

