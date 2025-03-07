import java.util.Scanner;

public class Assign52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int stlen = sc.nextInt();
            String s = Double.toString(n);
            for(int i=1;i<=stlen-Double.toString(n).length();i++) {
                s=s+"0";
            }
            System.out.println(s);
    
        // else {
        //     // String fn = String.format("%O"+stlen+"d",n);
        //     // System.out.println(fn);
        //     System.out.printf("%O"+stlen+"d%n",n);
        // }
        // String formattedNumber = String.format("%." + (stlen - 1) + "f", n);
        
    }
}
