import java.util.Scanner;

public class Firstandlastoccur {
    public static int first = -1;
    public static int last = -1;
    public static void firstAndLast (String s, int i, char c) {
        if (i==s.length()-1) {
          if(s.charAt(i) == c) {
            if (first == -1)
                first = i;
            else
                last = i;
            }
            System.out.println(first+" "+last);
            return;
        }
        if(s.charAt(i) == c) {
            if (first == -1)
                first = i;
            else
                last = i;
        }
        firstAndLast(s, i+1, c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        firstAndLast(s, 0, 'a');
        sc.close();
    }
}
