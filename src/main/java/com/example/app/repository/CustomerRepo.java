package com.example.app.repository;

import com.example.app.model.Customer;

import java.util.List;

public interface CustomerRepo {

    List<Customer> allCustomers();

    Customer getById(Long id);

    void updateCustomer(Customer customer);

    Customer createCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
