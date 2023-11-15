package org.api.serasa.repository;

import org.api.serasa.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, String> {
    CustomerModel findByCpf(String cpf);

}
