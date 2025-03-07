public class Student {
    public String enrollment_id;
    public String name;
    public String contact_no;
    public String aadhar_no;
    Student(String enrollment_id,String name) {
        this(enrollment_id, name, null);
    }
    Student(String enrollment_id,String name,String contact_no) {
        this(enrollment_id, name, contact_no, null);
    }
    Student(String enrollment_id,String name ,String contact_no,String aadhar_no) {
        this.enrollment_id = enrollment_id;
        this.name = name;
        this.contact_no = contact_no;
        this.aadhar_no = aadhar_no;
    }
    public static void main(String[] args) {
        Student s1 = new Student("2202111140","Priyanka");
        Student s2 = new Student("2202111186", "Nayan", "1234567890");
        Student s3 = new Student("2202111001", "Trushika", "1265489090", "5766398");
        System.out.println(s1.enrollment_id+" "+s1.name+" "+s1.contact_no+" "+s1.aadhar_no);
        System.out.println(s2.enrollment_id+" "+s2.name+" "+s2.contact_no+" "+s2.aadhar_no);
        System.out.println(s3.enrollment_id+" "+s3.name+" "+s3.contact_no+" "+s3.aadhar_no);
    }
}
