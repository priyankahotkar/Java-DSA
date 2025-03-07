import java.util.Scanner;

class MyException extends Exception {
    MyException(String msg) {
        super(msg);
    }
}

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        try {
            if (n2 == 0) {
                throw new MyException("Divide by zero error");
            }
            int ans = n1 / n2;
            System.out.println(ans);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Success");
        }
    }
}
