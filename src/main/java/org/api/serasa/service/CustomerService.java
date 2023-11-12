package org.api.serasa.service;

import jakarta.persistence.EntityNotFoundException;
import org.api.serasa.dto.CustomerRequestDTO;
import org.api.serasa.mapper.CustomerMapper;
import org.api.serasa.model.CustomerModel;
import org.api.serasa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerModel saveCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            if (customerRequestDTO != null) {
                CustomerModel customerModel = customerMapper.convertToEntity(customerRequestDTO);
                customerModel.setCpf(customerRequestDTO.getCpf());
                return customerRepository.save(customerModel);
            } else {
                throw new IllegalArgumentException("CustomerRequestDTO cannot be null.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving Customer", e);
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

    public void deleteCustomerByCpf(String cpf) {
        CustomerModel existingCustomer = getCustomerByCpf(cpf);
        customerRepository.delete(existingCustomer);
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
