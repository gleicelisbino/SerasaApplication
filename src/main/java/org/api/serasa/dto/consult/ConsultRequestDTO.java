package org.api.serasa.dto.consult;

import jakarta.persistence.*;
import lombok.Data;
import org.api.serasa.model.CustomerModel;

import java.util.Date;

@Data
public class ConsultRequestDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataConsult;

    @ManyToOne
    @JoinColumn(name = "customer_cpf", referencedColumnName = "cpf")
    private CustomerModel customer;
}
