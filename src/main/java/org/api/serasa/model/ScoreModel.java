package org.api.serasa.model;

import jakarta.persistence.*;
import lombok.Data;

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
