class Shape {
    String color;
    public void area() {
        System.out.println("Displays area");
    }
}
class Triangle extends Shape{
    public void area(int base, int height) {
        System.out.println(1/2*base*height);
    }
}
class Equilateraltriangle extends Triangle {
    public void area(int base, int height) {
        System.out.println(1/2*base*height);
    }
}   
class Circle extends Shape {
    public void area(int radius) {
        System.out.println(3.14*radius*radius);
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "Red";
        
    }
}
