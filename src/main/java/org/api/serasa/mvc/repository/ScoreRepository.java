package org.api.serasa.mvc.repository;

import org.api.serasa.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreModel, Long> {
}
