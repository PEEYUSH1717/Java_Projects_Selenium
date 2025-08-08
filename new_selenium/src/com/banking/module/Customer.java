package com.banking.module;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String accountType;

    public Customer(int id, String name, int age, String accountType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.accountType = accountType;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
