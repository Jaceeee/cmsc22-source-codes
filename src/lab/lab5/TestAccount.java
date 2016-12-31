package lab.lab5;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
public class TestAccount{
    public static void main(String args[]){
        Account a = new Account(1);
        a.setBalance(1500.00);
        System.out.printf("%.2f\n",a.getBalance());
        a.credit(100.00);
        System.out.printf("%.2f\n",a.getBalance());
        a.debit(50.00);
        System.out.println(a.getBalance());
        System.out.println(a.toString());
        a.credit(-2344);
    }
}
