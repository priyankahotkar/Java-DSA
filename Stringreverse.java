import java.util.Scanner;

public class Stringreverse {
    public static void reverseString(String s,int i) {
        if (i==0) {
            System.out.print(s.charAt(i));
            return;
        }
        System.out.print(s.charAt(i));
        reverseString(s, i-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        reverseString(s, s.length()-1);
        sc.close();
    }
}
