package com.example.app.service.impl;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepo;
import com.example.app.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepo.allCustomers();
    }

    @Override
    @Transactional
    public Customer updateCustomer(Customer customer) {
        customerRepo.updateCustomer(customer);
        return customer;
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = customerRepo.getById(id);
        customerRepo.deleteCustomer(customer);
    }
}
