public class OOPSSS {
    public static void main(String[] args) {
        Dog d = new Dog("Cat");
        Cat c = new Cat("Mouse");
    }
}
class Animals{
    String name;
    Animals(String name){
        this.name = name;
        System.out.println("Hello"); 
    }
}

class Dog extends Animals{
    String loves;
    Dog(String loves) {
        super("dog");
        this.loves = loves;
        System.out.println(this.name+" loves "+this.loves);
        
    }


}

class Cat extends Animals{
    String loves;
    Cat(String loves){
        super("Cat");
        this.loves = loves;
        System.out.println(this.name+" loves "+this.loves);
    }

}