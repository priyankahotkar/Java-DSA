import java.util.Scanner;

public class BitmanipulationHW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int count = 0;
        for (int position = 0; position<=8 ;position++) {
            int bitMask = 1<<position;                   
            if ((n & bitMask ) != 0) 
                count++;
        }
        System.out.println(count);
        sc.close();
    }
}
