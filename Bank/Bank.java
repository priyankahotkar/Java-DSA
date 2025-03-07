package Bank;
class Account {
    public String name;
    protected String email;
    private String password;
    public String getpassword () {
        return this.password;
    }
    public void setpassword(String pwd) {
        this.password = pwd;
    }
}
public class Bank {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.name = "Apna College";
        account1.email = "apnacollege@gmail.com";
       // account1.password = "apnacollege@123";
       account1.setpassword("apnacollege@123");
       System.out.println(account1.getpassword());

    }
}
