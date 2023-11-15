package org.api.serasa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CustomerModel {
    @Id
    private String cpf;
    private String address;
    private String email;
    private String name;
    private Date birthdayDate;
}

