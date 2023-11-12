package org.api.serasa.service;

import jakarta.persistence.EntityNotFoundException;
import org.api.serasa.model.CustomerModel;
import org.api.serasa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerModel saveCustomer(CustomerModel customerModel) {
        try {
            if (customerModel != null) {
                return customerRepository.save(customerModel);
            } else {
                throw new IllegalArgumentException("CustomerModel cannot be null.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error to save Customer", e);
        }
    }

    public CustomerModel updateCustomerByCpf(CustomerModel updatedCustomer, String cpf) {
            CustomerModel existingCustomer = getCustomerByCpf(cpf);
                existingCustomer.setName(updatedCustomer.getName());
                existingCustomer.setBirthdayDate(updatedCustomer.getBirthdayDate());
                existingCustomer.setAddress(updatedCustomer.getAddress());
                existingCustomer.setEmail(updatedCustomer.getEmail());
                return customerRepository.save(existingCustomer);
    }
    public CustomerModel getCustomerByCpf(String cpf) {
        try {
            return customerRepository.findByCpf(cpf)
                    .orElseThrow(() -> new EntityNotFoundException("Customer can not be found: " + cpf));
        } catch (Exception e) {
            throw new RuntimeException("Error to save Customer", e);
        }
    }
}
