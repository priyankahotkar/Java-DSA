public class BitManipulation2 {
    public static boolean isEven(int n) {   //Even numbers have last bit or LSB as 0
        return (n & 1) == 0;
    }
    public static void main(String[] args) {
        // System.out.println(5<<2); // 5*2^2 = 20
        // System.out.println(5<<3); // 5*2^3 = 40
        // System.out.println(6>>1); // 6/2^1 = 3
        // System.out.println(6>>2); // 6/2^2 = 1

        System.out.println(isEven(23));
    }
}
