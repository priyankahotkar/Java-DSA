public class Trial {
    public static void main(String[] args) {
        Home h = new Home();
        h.addressName("ayodhya nagar..."); 
        h.printOfficeName("Microsoft..");
    }
}
abstract class Office{
    void printOfficeName(String name){
        System.out.println(name);

    }
    abstract void addressName(String address);
}
class Home extends Office{
    void addressName(String address) {
        System.out.println(address);
    }
}
