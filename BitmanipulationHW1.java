import java.util.Scanner;

public class BitmanipulationHW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int position = 0;
        int bitMask = 1<<position;                   
        if ((n & bitMask ) == 0) 
            System.out.println("Multiple of 2");
        else
            System.out.println("Not a multiple of 2");
        sc.close();
    }
}
