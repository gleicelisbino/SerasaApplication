package org.api.serasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.api.serasa.dto.score.ScoreRequestDTO;
import org.api.serasa.dto.score.ScoreResponseDTO;

@Data
@Entity
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;

    @OneToOne
    private CustomerModel customerModel;
}
