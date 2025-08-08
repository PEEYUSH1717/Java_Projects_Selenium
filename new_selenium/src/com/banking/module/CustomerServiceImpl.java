package com.banking.module;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private Map<Integer, Customer> customerMap = new HashMap<>();

    public void registerCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
        System.out.println("Customer " + customer.getName() + " registered.");
    }

    public void showCustomerDetails(int customerId) {
        Customer c = customerMap.get(customerId);
        if (c != null) {
            System.out.println("ID: " + c.getId());
            System.out.println("Name: " + c.getName());
            System.out.println("Age: " + c.getAge());
            System.out.println("Account Type: " + c.getAccountType());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
