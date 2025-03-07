interface Animal {          //purely abstract,cannott make its constructor
    void walk();
    int eyes = 2;
}
interface Herbivore {

}
class A {
    void printAnimal() {
        System.out.println("Animal name is : ");
    }
}
class Horse extends A implements Animal,Herbivore{
    public void walk() {
        System.out.println("Walk on 4 legs");
    }
}

public class Interface {
    public static void main(String[] args) {
        
    }
}
