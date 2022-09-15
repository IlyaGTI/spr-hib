package com.example.app.service;

import com.example.app.model.Customer;

import java.util.*;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    Customer createCustomer(Customer customer);

    void deleteCustomer(Long id);

}
