public class Abstcl {
    public static void main(String[] args) {
        Maya m = new Maya();
        m.printStudentid("2202111186");
        m.printrollno(47);
    }
}
abstract class Nayan {
    void printStudentid(String studentid) {
        System.out.println(studentid);
    }
    abstract void printrollno(int rollNo);
}
class Maya extends Nayan{
    void printrollno(int rollNo) {
        System.out.println(rollNo);
    }
}
