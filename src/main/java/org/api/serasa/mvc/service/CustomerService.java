package org.api.serasa.mvc.service;

import org.api.serasa.dto.customer.CustomerRequestDTO;
import org.api.serasa.dto.customer.CustomerResponseDTO;
import org.api.serasa.mapper.CustomerMapper;
import org.api.serasa.model.CustomerModel;
import org.api.serasa.mvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            if (customerRequestDTO != null) {
                CustomerModel customerModel = customerMapper.convertToEntity(customerRequestDTO);
                customerModel.setCpf(customerRequestDTO.getCpf());
                return customerMapper.convertToDTO(customerRepository.save(customerModel));
            } else {
                throw new IllegalArgumentException("CustomerRequestDTO cannot be null.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving Customer", e);
        }
    }

    public CustomerResponseDTO updateCustomerByCpf(CustomerRequestDTO updatedCustomer, String cpf) {
            CustomerModel existingCustomer = customerRepository.findByCpf(cpf);
                existingCustomer.setName(updatedCustomer.getName());
                existingCustomer.setBirthdayDate(updatedCustomer.getBirthdayDate());
                existingCustomer.setAddress(updatedCustomer.getAddress());
                existingCustomer.setEmail(updatedCustomer.getEmail());
                return customerMapper.convertToDTO(customerRepository.save(existingCustomer));
    }

    public void deleteCustomerByCpf(String cpf) {
        CustomerModel existingCustomer = customerRepository.findByCpf(cpf);
        customerRepository.delete(existingCustomer);
}
    public CustomerResponseDTO getCustomerByCpf(String cpf) {
        try {
            return customerMapper.convertToDTO(customerRepository.findByCpf(cpf));
        } catch (Exception e) {
            throw new RuntimeException("Error to save Customer", e);
        }
    }

}
