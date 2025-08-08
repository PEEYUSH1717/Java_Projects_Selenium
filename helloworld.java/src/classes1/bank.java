package classes1;

public class bank {
	    String name;
	    int balance;
	    void deposit(int amount) {
	        balance = balance + amount;
	        System.out.println("Deposited: " + amount);
	    }
	    void withdraw(int amount) {
	        balance = balance - amount;
	        System.out.println("Withdrawn: " + amount);
	    }
	    void showInfo() {
	        System.out.println("Name: " + name);
	        System.out.println("Balance: " + balance);
	    }
	    public static void main(String[] args) {
	        bank b = new bank(); 
	        b.name = "Aman";                  
	        b.balance = 100000;                

	        b.deposit(5000);                   
	        b.withdraw(2000);                
	        b.showInfo();                     
	    }}
