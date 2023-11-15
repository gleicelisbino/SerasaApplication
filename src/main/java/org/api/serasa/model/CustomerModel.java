package org.api.serasa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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