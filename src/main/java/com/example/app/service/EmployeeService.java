package com.example.app.service;

import com.example.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee updateEmployee(Employee employee);

    Employee createEmployee(Employee employee);

    void deleteEmployee(Long id);

}
