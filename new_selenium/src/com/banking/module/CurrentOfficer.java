package com.banking.module;

public class CurrentOfficer extends BankOfficer {
    public CurrentOfficer(String name) {
        super(name, "Current Account Officer");
    }

    public void processAccount(Customer customer) {
        System.out.println(designation + " " + name + " is processing account for: " + customer.getName());
        if (customer.getAccountType().equalsIgnoreCase("Current")) {
            System.out.println("Current account verified and activated.");
        } else {
            System.out.println("This officer handles only current accounts.");
        }
    }
}
