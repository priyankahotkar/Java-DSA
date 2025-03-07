import java.util.Scanner;

public class Sortstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char arr[] = new char[a.length()];
            arr = a.toCharArray();
            for (int i = 0; i < arr.length-1; i++) {
                for(int j = i+1;j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                }
            }
            a = arr.toString();
            System.out.println(a);
        }
}
