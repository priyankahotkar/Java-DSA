import java.util.Scanner;

public class Backtracking {
    public static void printPermutations (String str , String permutation, int i) {
        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            String newString = str.substring(0, j) + str.substring(j+1);
            printPermutations(newString, permutation+str.charAt(j), i+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPermutations(str, "", 0);
        sc.close();
    }
}
