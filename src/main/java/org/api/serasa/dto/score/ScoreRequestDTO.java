package org.api.serasa.dto.score;


import jakarta.persistence.*;
import lombok.Data;
import org.api.serasa.model.CustomerModel;

import java.util.Date;

@Data
public class ScoreRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToOne
    @JoinColumn(name = "customer_cpf", referencedColumnName = "cpf")
    private CustomerModel customer;
}
