class Student {
    String name;
    static String school;
    public static void changeSchool () {
        school = "ABC";
    }
}
public class Staticmembers {
    public static void main(String[] args) {
        Student.school = "SRC";
        Student s1 = new Student();
        s1.name = "Tony";
        Student.changeSchool();
        System.out.println(s1.school);
    }
}
