package org.api.serasa.controller;

import org.api.serasa.model.CustomerModel;
import org.api.serasa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel) {
        return new ResponseEntity<>(customerService.saveCustomer(customerModel), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerByCpf/{cpf}")
    public ResponseEntity<CustomerModel> getCustomerByCpf(@PathVariable String cpf) {
        try {
            CustomerModel customer = customerService.getCustomerByCpf(cpf);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}