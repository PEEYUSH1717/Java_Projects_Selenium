package abstraction;

abstract class Payment {
    abstract void makePayment(double amount);
}
class CreditCard extends Payment {
    void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}
class Upi extends Payment {
    void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}
public class credit {
    public static void main(String[] args) {
        Payment creditPayment = new CreditCard(); 
        creditPayment.makePayment(1000);

        Payment upiPayment = new Upi(); 
        upiPayment.makePayment(500);
    }
}
