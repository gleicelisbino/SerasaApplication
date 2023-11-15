package org.api.serasa.controller;

import org.api.serasa.dto.CustomerRequestDTO;
import org.api.serasa.dto.CustomerResponseDTO;
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
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerModel) {
        return new ResponseEntity<>(customerService.saveCustomer(customerModel), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomerByCpdf/{cpf}")
        public ResponseEntity<CustomerResponseDTO> deleteCustomerByCpf(@PathVariable String cpf){
        try{
            customerService.deleteCustomerByCpf(cpf);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCustomerByCpf/{cpf}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByCpf(@PathVariable String cpf) {
        try {
            return new ResponseEntity<>( customerService.getCustomerByCpf(cpf), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCustomerByCpf/{cpf}")
    public ResponseEntity<CustomerResponseDTO> updateCustomerByCpf(@RequestBody
                                                                 CustomerRequestDTO customerModel,
                                                             @PathVariable String cpf){
        try {
            return new ResponseEntity<>(customerService.updateCustomerByCpf(customerModel,cpf), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}