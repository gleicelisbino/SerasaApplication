package org.api.serasa.controller;

import org.api.serasa.model.CustomerModel;
import org.api.serasa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerModel> createCustomers(@RequestBody CustomerModel customerModel) {
        return new ResponseEntity<>(CustomerService.saveCustomer(customerModel), HttpStatus.CREATED);
    }

}