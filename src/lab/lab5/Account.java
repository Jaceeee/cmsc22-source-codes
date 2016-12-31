package lab.lab5;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
public class Account{
    private int accountNumber;
    private double balance;

    Account(int accNum){
        accountNumber = accNum;
        balance = 0.0;
    }

    Account(int accNum, double bal){
        accountNumber = accNum;
        setBalance(bal);
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double bal){
        if(bal < 0.0){
            throw new IllegalArgumentException("Negative values not permitted.");
        }
        balance = bal;
    }

    public void credit(double amount){
        if(amount < 0.0){
            throw new IllegalArgumentException("Negative values are not permitted.");
        }
        balance = balance + amount;
    }

    public void debit(double amount){
        if(amount < 0.0){
            throw new IllegalArgumentException("Negative values are not permitted.");
        }
        if(balance >= amount){
            balance = balance - amount;
        } else {
            System.out.println("amount withdrawn exceeds the current balance.");
        }
    }

    public String toString(){
        String ans;
        ans = String.format("A/C no:%03d, Balance=$%.2f", accountNumber, balance);
        return ans;
    }

	/* this part isn't really required; i just wanted to present an alternative method
	public String toString(String name){
		String ans;
		ans = String.format("A/C no:%03d, Balance=$%.2f", accountNumber, balance);
		ans = ans + "Account Holder: " + name;
		return ans;
	}
	*/
}
