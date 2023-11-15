package org.api.serasa.mvc.repository;

import org.api.serasa.model.ConsultModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends CrudRepository<ConsultModel, Long> {
}
