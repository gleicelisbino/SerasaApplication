package org.api.serasa.dto.consult;
import lombok.Data;

import java.util.Date;

@Data
public class ConsultResponseDTO {

    private Long id;

    private Long customerId;

    private Date dataConsult;
}
