package org.api.serasa.dto.customer;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerRequestDTO {
    @Id
    private String cpf;

    private String address;
    private String email;
    private String name;

    private Date birthdayDate;
}
