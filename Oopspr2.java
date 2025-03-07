class Animal {
    Animal reproduce() {
        System.out.println("Animal reproduces");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog reproduce() { // Covariant return type
        System.out.println("Dog reproduces");
        return new Dog();
    }
}

public class Oopspr2 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal newAnimal = animal.reproduce(); // Calls Animal's reproduce method

        Dog dog = new Dog();
        Dog newDog = dog.reproduce(); // Calls Dog's reproduce method
    }
}

