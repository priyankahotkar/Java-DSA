import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        int inp;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter 1 to continue and 0 to stop : ");
            inp = sc.nextInt();
            System.out.print("Enter any number : ");
            int n = sc.nextInt();
            if (n>0)
                positive++;
            else if (n<0)
                negative++;
            else
                zeros++;
        }while(inp!=0);
        System.out.println("The number of postive numbers is : "+positive);
        System.out.println("The number of negative numbers is : "+negative);
        System.out.println("The number of zeroes is : "+zeros);
        sc.close();
    }
}
