import java.util.*;
public class Circle {
    public static void main(String[] args) {
       System.out.println("Enter radius of a circle : ");
       Scanner sc = new Scanner(System.in);
       float r = sc.nextFloat();
       double area = r*r;
       double perimeter = 2*3.14*r;
       System.out.print("Area is ");
       System.out.println(area);
       System.out.print("Perimeter is ");
       System.out.println(perimeter); 
       sc.close();
    }
}
