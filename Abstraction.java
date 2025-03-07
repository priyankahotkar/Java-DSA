abstract class Animal {
    abstract void walk();
    Animal() {
        System.out.println("You are creating a new animal");
    }
    public void eats () {
        System.out.println("Animal eats");
    }
}
class Horse extends Animal {
    Horse() {
        System.out.println("You are creating a new horse");
    }
    public void walk() {
        System.out.println("Walks on 4 legs"); 
    }
}
class Chicken extends Animal {
    public void walk() {
        System.out.println("Walks on 2 legs");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        Horse h1 = new Horse();
        h1.walk();
        h1.eats();
        // Chicken c1 = new Chicken();
        // c1.walk();
        // Animal a = new Animal();
        // a.walk();
    }
}
