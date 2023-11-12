package org.api.serasa.repository;

import org.api.serasa.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, String> {
    Optional<CustomerModel> findByCpf(String cpf);

}
