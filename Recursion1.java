public class Recursion1 {
    // public static void printFibonacci(int a,int b,int n) {
    //     if (n==0) {
    //         return;
    //     }
    //     int c = a+b;
    //     System.out.println(c);
    //     printFibonacci(b, c, n-1);
    //     //b=c;
    // }


    // public static int powerOfN(int x,int n) {        //stack height = n
    //     if(n==0)
    //         return 1;
    //     if (x==0)
    //         return 0;
    //     return x*powerOfN(x, n-1);
    // }


    public static int powerOfN(int x,int n) {         //stack height = logn
        if(n==0)
            return 1;
        if (x==0)
            return 0;
        if (n%2 == 0) {
            return powerOfN(x, n/2) * powerOfN(x, n/2);
        }
        else {
            return powerOfN(x, n/2) * powerOfN(x, n/2) * x;
        }
    }
    public static void main(String[] args) {
        // int a = 0;
        // int b = 1;
        // int n = 7;
        // System.out.println(a);
        // System.out.println(b);
        // printFibonacci(a,b,n-2);
        System.out.println(powerOfN(2, 5));
    }
}
