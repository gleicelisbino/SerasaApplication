package org.api.serasa.dto.customer;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponseDTO {
    @Id
    private String cpf;
    private String name;
    private Date birthdayDate;
    private String address;
    private String email;
}
