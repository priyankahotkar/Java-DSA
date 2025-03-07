class Parent {
    static void staticMethod() {
        System.out.println("Parent's static method");
    }
    
    void instanceMethod() {
        System.out.println("Parent's instance method");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Child's static method");
    }
    
    void instanceMethod() {
        System.out.println("Child's instance method");
    }
}

public class Oopspr3 {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.staticMethod(); // Calls Parent's static method (method hiding)
        parent.instanceMethod(); // Calls Child's instance method (method overriding)
    }
}
