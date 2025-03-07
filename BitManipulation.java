import java.util.Scanner;

public class BitManipulation {
    public static void getbit (int n , int position) {
        int bitMask = 1<<position;                   
        if ((n & bitMask ) != 0) 
            System.out.println("Bit is one");
        else
            System.out.println("Bit is zero");
    }
    public static int setbit (int n, int position) {
        int bitMask = 1<<position;
        return (n | bitMask);
    }
    public static int clearbit (int n , int position) {
        int bitMask = 1<<position;
        return (n & ~bitMask);
    }
    public static int updatebit (int n, int position , int updateTo) {
        if (updateTo == 1) 
            return setbit(n, position);
        else 
            return clearbit(n, position);
    }
    public static int clearLastIBits(int n, int i) {
        int bitMask = (~0) << i;
        return (n & bitMask);
    }
    public static int clearRangeOfBits(int n, int i, int j) {
        int a = (~0) << (j+1);
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return (n & bitMask);
    }
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static int fastExponentiation(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter a number : ");
        // int n = sc.nextInt();
        // System.out.print("Enter a position : ");
        // int position = sc.nextInt();
        // System.out.print("Enter to which bit it should be updated : ");
        // int updateTo = sc.nextInt();
        // System.out.println(updatebit(n, position, updateTo));
        System.out.println(fastExponentiation(5, 3));
        // sc.close();
    }
}
