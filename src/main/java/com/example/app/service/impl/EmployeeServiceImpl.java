package com.example.app.service.impl;

import com.example.app.model.Employee;
import com.example.app.repository.EmployeeRepo;
import com.example.app.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployee() {
        return employeeRepo.getAllEmpl();
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        employeeRepo.updateEmpl(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepo.createEmpl(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepo.getById(id);
        employeeRepo.deleteEmpl(employee);
    }
}
