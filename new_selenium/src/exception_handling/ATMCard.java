package exception_handling;

import java.util.*;

class InvalidLoginException extends Exception {
 public InvalidLoginException(String message) {
     super(message);
 }
}

class User {
 int pin;
 double balance;

 User(int pin, double balance) {
     this.pin = pin;
     this.balance = balance;
 }

 void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit successful. New balance: ₹" + balance);
 }

 void withdraw(double amount) {
     if (amount > balance) {
         System.out.println("Insufficient balance.");
     } else {
         balance -= amount;
         System.out.println("Withdrawal successful. New balance: ₹" + balance);
     }
 }

 void checkBalance() {
     System.out.println("Current balance: ₹" + balance);
 }
}

public class ATMCard {

 public static User login(Map<Integer, User> userMap, int card, int pin) throws InvalidLoginException {
     if (!userMap.containsKey(card)) {
         throw new InvalidLoginException("Card number not found.");
     }
     User user = userMap.get(card);
     if (user.pin != pin) {
         throw new InvalidLoginException("Incorrect PIN entered.");
     }
     return user;
 }

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     Map<Integer, User> userMap = new HashMap<>();
     userMap.put(1001, new User(1234, 5000.00));
     userMap.put(1002, new User(2345, 7500.50));
     userMap.put(1003, new User(3456, 3000.00));

     System.out.println("WELCOME TO XYZ BANK ATM");

     try {
         System.out.print("Insert your ATM card (enter card number): ");
         int enteredCard = scanner.nextInt();

         System.out.print("Enter your 4-digit PIN: ");
         int enteredPin = scanner.nextInt();

         User currentUser = login(userMap, enteredCard, enteredPin);
         System.out.println("\nLogin successful!");

         int choice;
         do {
             System.out.println("\nMENU");
             System.out.println("1. Check Balance");
             System.out.println("2. Deposit Money");
             System.out.println("3. Withdraw Money");
             System.out.println("4. Exit");
             System.out.print("Choose an option: ");
             choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     currentUser.checkBalance();
                     break;
                 case 2:
                     System.out.print("Enter amount to deposit: ₹");
                     double depositAmount = scanner.nextDouble();
                     currentUser.deposit(depositAmount);
                     break;
                 case 3:
                     System.out.print("Enter amount to withdraw: ₹");
                     double withdrawAmount = scanner.nextDouble();
                     currentUser.withdraw(withdrawAmount);
                     break;
                 case 4:
                     System.out.println("Exiting session...");
                     break;
                 default:
                     System.out.println("Invalid choice. Try again.");
             }

         } while (choice != 4);

     } catch (InvalidLoginException e) {
         System.out.println("Login Failed: " + e.getMessage());
     } catch (InputMismatchException e) {
         System.out.println("Invalid input. Please enter numbers only.");
     } finally {
         System.out.println("\nTransaction completed.");
         System.out.println("Please collect your card.");
         System.out.println("Thank you for using XYZ Bank ATM.");
         scanner.close();
     }
 }
}
