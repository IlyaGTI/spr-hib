package com.example.app.controller;

import com.example.app.controller.msg.Message;
import com.example.app.model.Customer;
import com.example.app.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Api
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @ApiOperation("Список всех клиентов")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation("Добавление данных о клиенте")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation("Изменение данных о клиенте")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление данных о клиенте")
    public ResponseEntity<Message> deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new Message("Клиент удален"), HttpStatus.OK);
    }

}
