package org.api.serasa.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private Date birthdayDate;
    private String address;
    private String cpf;
    private String email;
}
