package com.banking.module;

public class BankingMain {
    public static void main(String[] args) {
        Customer c1 = new Customer(1, "Johnny", 30, "Savings");
        Customer c2 = new Customer(2, "Mike", 40, "Current");

        CustomerService service = new CustomerServiceImpl();
        service.registerCustomer(c1);
        service.registerCustomer(c2);

        System.out.println("\nShowing Customer Details:");
        service.showCustomerDetails(1);
        service.showCustomerDetails(2);

        BankOfficer officer1 = new SavingsOfficer("Mr. Tom");
        BankOfficer officer2 = new CurrentOfficer("Mr. Peter");

        System.out.println("\nAccount Processing:");
        officer1.processAccount(c1);  
        officer2.processAccount(c1);  
        officer1.processAccount(c2);  
        officer2.processAccount(c2);  
    }
}
