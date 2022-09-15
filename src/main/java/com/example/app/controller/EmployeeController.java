package com.example.app.controller;

import com.example.app.controller.msg.Message;
import com.example.app.model.Employee;
import com.example.app.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Api
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    @ApiOperation("Вывод всех работников")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation("Добавление данных работника")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation("Обнавление данных работника")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаления работника")
    public ResponseEntity<Message> deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity(new Message("Работник удален"), HttpStatus.OK);
    }

}
