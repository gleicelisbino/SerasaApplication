package org.api.serasa.dto.score;

import jakarta.persistence.*;
import lombok.Data;
import org.api.serasa.model.CustomerModel;

@Data
public class ScoreResponseDTO {
    @Id
    private Long id;

    private int points;

    @OneToOne
    private CustomerModel customerModel;
}
