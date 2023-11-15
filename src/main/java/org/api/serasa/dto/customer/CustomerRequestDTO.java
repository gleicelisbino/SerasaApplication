package org.api.serasa.dto.customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.api.serasa.model.ConsultModel;
import org.api.serasa.model.ScoreModel;

import java.util.Date;
import java.util.List;

@Data
public class CustomerRequestDTO {
    @Id
    private String cpf;
    private String address;
    private String email;
    private String name;
    private Date birthdayDate;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private ScoreModel score;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultModel> consults;
}
