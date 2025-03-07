import java.util.*;
public class Switch {
    public static void main(String[] args) {
        System.out.print("Enter your choice(1-3) : ");
        Scanner sc = new Scanner(System.in);
        String ch = sc.next();
        switch (ch) {
            case "1":
                System.out.println("Hello");
                break;
            case "2":
                System.out.println("Namaste");
                break;
            case "3":
                System.out.println("Bonjour");
                break;
            default:
                System.out.println("Invalid button");
                break;
        }
        sc.close();
    }
}
