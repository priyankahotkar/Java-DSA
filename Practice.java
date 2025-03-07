abstract class Abc {
    abstract void printName(String name);
    void series () {
        System.out.println("Series");
    }
}
interface B {
    void prime(int n);
}
class P extends Abc {
    P() {
       System.out.println("p"); 
    }
    P(int a) {
        System.out.println(a+1);
    }
    P(int n , String s) {
        System.out.println(s+" "+n);
    }
    private int number ;
    int getNumber () {
        return number;
    }
    void setNumber(int number) {
        this.number = number;
    }
    void printName(String name) {
        System.out.println(name);
    }
}
public class Practice {
    public static void main(String[] args) {
        P p1 = new P(1,"Pri");
        p1.printName("Priyanka");
        p1.series();
        // p1.setNumber(47);
        // System.out.println(p1.getNumber());

    }
}