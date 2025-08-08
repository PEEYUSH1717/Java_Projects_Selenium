package com.banking.module;

public abstract class BankOfficer {
    protected String name;
    protected String designation;

    public BankOfficer(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }
    public abstract void processAccount(Customer customer);
}
