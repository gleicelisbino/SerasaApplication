package org.api.serasa.dto.consult;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultRequestDTO {

    @NotNull
    private Long customerId;
}
