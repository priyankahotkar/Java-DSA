public class Constructors {
    public static void main(String[] args) {
        Hi a = new Hi();
        Hi b = new Hi("nayan");
        Hi c = new Hi("nayan","Priyanka");
    }
}
class Hi {
    String name; 
    String frnd_name;
    Hi() {
        System.out.println("Hi");
    }
    Hi(String name) {
        this.name = name;
        System.out.println("Hi "+this.name);
    }
    Hi(String name ,String frnd_name) {
        this.name = name;
        this.frnd_name = frnd_name;
        System.out.println(this.frnd_name+" says Hi to "+this.name);
    }
}