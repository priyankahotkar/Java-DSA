import java.util.Scanner;

public class Stringsbasics {
    public static void main(String[] args) {
        // String name = "Priyanka";
        // String fullname = "Priyanka Hotkar";
        /*Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);
        sc.close();*/
        // String firstname = "Priyanka";
        // String lastname = "Hotkar";
        // String fullname = firstname +" "+ lastname;
        // System.out.println(fullname.length());      //length of string
        // for (int i = 0; i < fullname.length(); i++) {
        //     System.out.println(fullname.charAt(i));    //print each character
        // }
        
        //comparing 2 strings
        // String name1 = "Tony10";
        // String name2 = "Tony";
        // System.out.println(name1.compareTo(name2)); //returns difference between ascii values of first dissimilar character or else difference in lenghths

        // if (new String("Tony") == new String("Tony")) {
        //    System.out.println("Strings are equal"); 
        // } else {
        //     System.out.println("Strings are not equal");
        // }
        
        String sentence = "Priyanka Hotkar";
        System.out.println(sentence.substring(9));
        //Strings are immutable
    }
}
