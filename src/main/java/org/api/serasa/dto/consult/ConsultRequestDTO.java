package org.api.serasa.dto.consult;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.api.serasa.model.CustomerModel;

import java.util.Date;

@Data
public class ConsultRequestDTO {

    private Long id;

    @ManyToOne
    private CustomerModel customerModel;

    private Date dataConsult;
}
