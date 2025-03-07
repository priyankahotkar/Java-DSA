
// Abstract class
abstract class Shape {
    abstract double area(); // Abstract method
}

// Concrete class extending abstract class
class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

// Interface
interface Drawable {
    void draw(); // Abstract method
}

// Concrete class implementing interface
class Rectangle implements Drawable {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}

public class Oopspr5 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Area of circle: " + circle.area()); // Output: Area of circle: 78.53981633974483
        
        Rectangle rectangle = new Rectangle(4, 3);
        rectangle.draw(); // Output: Drawing rectangle
    }
}
