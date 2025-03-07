class Pen {
    String color;
    String type;
    public void write() {
        System.out.println("Writing something");
    }
    public void printColor() {
        System.out.println(this.color);
    }
}

class Student {
    String name;
    int age;
    public void printInfo() {
        System.out.println(this.name + " " + this.age);
    }
    // Student(String name, int age) {         //parameterized constructors
    //     this.name = name;
    //     this.age = age;
    //     System.out.println("Constructor called");
    // }
    Student(Student s2) {       //copy constructor
        this.name = s2.name;
        this.age = s2.age;
    }
    Student() {

    }
}
public class OOPS1 {
    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.color = "Blue";
        // p1.type = "Gel";
        // p1.write();
        // Pen p2 = new Pen();
        // p2.color = "Black";
        // p2.type = "Ballpoint";
        // p1.printColor();
        // p2.printColor();
        Student s1 = new Student();             //Constructors : name same as class name
        s1.name = "Priyanka";                                   // no return type
        s1.age = 19;                                            // only one time called for a single object
        
        Student s2 = new Student(s1);
        s2.printInfo();
    }
}
