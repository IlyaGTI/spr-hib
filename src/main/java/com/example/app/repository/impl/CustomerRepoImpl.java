package com.example.app.repository.impl;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepo;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerRepoImpl implements CustomerRepo {

    private final LocalSessionFactoryBean localSessionFactoryBean;

    public CustomerRepoImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        this.localSessionFactoryBean = localSessionFactoryBean;
    }

    @Override
    public List<Customer> allCustomers() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        return session.createQuery("from  Customer ").getResultList();
    }

    @Override
    public Customer getById(Long id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.delete(customer);
    }
}
