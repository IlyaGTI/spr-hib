package com.example.app.repository.impl;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepo;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    private final LocalSessionFactoryBean sessionFactoryBean;

    public EmployeeRepoImpl(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Employee> getAllEmpl() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        return  session.createQuery("from Employee ").getResultList();
    }

    @Override
    public void updateEmpl(Employee employee) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee createEmpl(Employee employee) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.save(employee);
        return employee;
    }

    @Override
    public void deleteEmpl(Employee employee) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.delete(employee);
    }

    @Override
    public Employee getById(Long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        return session.get(Employee.class, id);
    }
}
