class InsufficientBalance extends Exception{
    InsufficientBalance(String msg) {
        super(msg);
    }
}
class Transactions extends Thread {
    String transactiontype;
    float accountBalance;
    float amount;
    Transactions(String transactiontype , float amount) {
        this.transactiontype = transactiontype;
        this.amount = amount;
    }
    public void run() {
        if (this.transactiontype == "Deposit") {
            this.accountBalance += this.amount;
        }
        else if(this.transactiontype == "Withrawal") {
            this.accountBalance -= this.amount;
            if (this.accountBalance<0) {
                try {
                throw new InsufficientBalance("Your account has insuffient balance!!!");
                }
                catch(InsufficientBalance e) {
                    System.out.println(e.getMessage());
                }
            }
            
        }
        else {
            System.out.println("Invalid Transaction!!!");
        }
    }
}
class Accounts extends Transactions {
    String account_number;
    Accounts(String transactiontype, float amount , String account_number) {
        super(transactiontype, amount);
        this.account_number = account_number;
        System.out.println("Account number is : "+this.account_number);
    }
}
public class Bankingsystem {
    public static void main(String[] args) {
        Accounts t1 = new Accounts("Deposit", 100000, "AFG40078");
        Accounts t2 = new Accounts("Withrawal", 10000, "GRT47800");
        t1.run();
        System.out.println(t1.accountBalance);
        t2.run();
        System.out.println(t2.accountBalance);
    }
}
