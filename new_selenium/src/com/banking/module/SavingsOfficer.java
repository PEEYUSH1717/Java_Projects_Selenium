package com.banking.module;

public class SavingsOfficer extends BankOfficer {
    public SavingsOfficer(String name) {
        super(name, "Savings Officer");
    }

    public void processAccount(Customer customer) {
        System.out.println(designation + " " + name + " is processing account for: " + customer.getName());
        if (customer.getAccountType().equalsIgnoreCase("Savings")) {
            System.out.println("Savings account verified and activated.");
        } else {
            System.out.println("This officer handles only savings accounts.");
        }
    }
}
