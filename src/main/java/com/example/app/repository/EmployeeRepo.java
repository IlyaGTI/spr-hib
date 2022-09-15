package com.example.app.repository;

import com.example.app.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo {

    List<Employee> getAllEmpl();

    void updateEmpl(Employee employee);

    Employee createEmpl(Employee employee);

    void deleteEmpl(Employee employee);

    Employee getById(Long id);

}
