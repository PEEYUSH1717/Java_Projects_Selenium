package encapsulation;

public class Bank {
	    private double balance; 

	    public void deposit(double amount) {
	        if (amount > 0) balance += amount;
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) balance -= amount;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public static void main(String[] args) {
	        Bank acc = new Bank();

	        acc.deposit(10000);    
	        acc.withdraw(4000);     

	        System.out.println("Balance: " + acc.getBalance());
	    }}

