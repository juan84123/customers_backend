package com.localhost.customersAPI.controllers;
import com.localhost.customersAPI.beans.Customer;
import com.localhost.customersAPI.daos.CustomersDAO;
import com.localhost.customersAPI.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomersAPI {
    @Autowired
    CustomersServices services;
    @Autowired
    CustomersDAO dao;
        @GetMapping("/status")
        public String okResponse() {
            return "OK";
        }
        @PostMapping("/create")
        public String createUser(@RequestBody String personalData) {
        Customer customer = services.transformAndValidateCustomer(personalData);
        dao.insertCustomer(customer);
        return "User created successfully";
    }
}
