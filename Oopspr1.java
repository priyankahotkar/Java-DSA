class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

interface Pet {
    String name;
    void play();
}

class Dog extends Animal implements Pet {
    public void play() {
        System.out.println("Dog plays fetch");
    }
    
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal implements Pet {
    public void play() {
        System.out.println("Cat plays with yarn");
    }
    
    void sound() {
        System.out.println("Cat meows");
    }
}

// Diamond problem arises here
class RobotPet extends Dog,Cat{ // Error: Multiple inheritance is not supported in Java
    // Implement common methods or specify which method to call
}
