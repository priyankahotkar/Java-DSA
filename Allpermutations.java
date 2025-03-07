import java.util.Scanner;

public class Allpermutations {
    public static void printPermutations(String str, String permutations) {
        if (str.length() == 0) {
            System.out.println(permutations);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutations(newStr, permutations+currChar);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPermutations(str, "");
        sc.close();
    }
}
