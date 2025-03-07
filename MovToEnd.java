import java.util.Scanner;

public class MovToEnd {
    public static void moveToEnd(String s,int i, char c,int count, String new_String) {
        if (i==s.length()) {
            for (int j = 1; j<=count ; j++)
                new_String += c ;
            System.out.println(new_String);
            return;
        }
        if (s.charAt(i) != c)
            new_String += s.charAt(i);
        else
            count+=1;
        moveToEnd(s, i+1, c, count, new_String);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        moveToEnd(s, 0, 'x', 0, "");
        sc.close();
    }
}
