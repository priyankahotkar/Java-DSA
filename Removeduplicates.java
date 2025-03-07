import java.util.Scanner;

public class Removeduplicates {
    public static boolean[] arr = new boolean[26];
    public static void removeDuplicates(String s,int i,String newString) {
        if (i==s.length()) {
            System.out.println(newString);
            return;
        }
       if (arr[s.charAt(i)-'a'] == false) 
            newString += s.charAt(i);
        arr[s.charAt(i)-'a'] = true;
       removeDuplicates(s, i+1, newString);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        removeDuplicates(s, 0, "");
        sc.close();
    }
}
