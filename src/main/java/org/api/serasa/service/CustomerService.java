package org.api.serasa.service;

import org.api.serasa.model.CustomerModel;
import org.api.serasa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerModel saveCustomer(CustomerModel customerModel) {
        if (customerModel != null) {
            return customerRepository.save(customerModel);
        } else {
            throw new IllegalArgumentException("CustomerModel cannot be null.");
        }
    }
}
