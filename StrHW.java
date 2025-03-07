import java.util.Scanner;

public class StrHW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter size : ");
        // int size = sc.nextInt();
        // String[] arr = new String[size];
        // int totallength = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = sc.next();
        //     totallength += arr[i].length();
        // }
        // System.out.println("Total length is "+totallength);


        // String str = sc.nextLine();
        // String result;
        // if (str.contains("e")) {
        //     result = str.replace("e", "i");
        // }
        // else {
        //     result = str;
        // }
        // System.out.println(result);


        System.out.print("Enter email : ");
        String em = sc.nextLine();
        StringBuilder email = new StringBuilder(em);
        int i = email.indexOf("@");
        email.delete(i, email.length());
        System.out.println("Username is : "+email);
        sc.close();
    }
}
