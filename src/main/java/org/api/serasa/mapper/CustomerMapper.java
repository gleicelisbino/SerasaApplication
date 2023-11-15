package org.api.serasa.mapper;

import org.api.serasa.dto.customer.CustomerRequestDTO;
import org.api.serasa.dto.customer.CustomerResponseDTO;
import org.api.serasa.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerModel convertToEntity(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO convertToDTO(CustomerModel customerModel);

    void updateEntityFromDTO(@MappingTarget CustomerModel customerModel, CustomerRequestDTO customerRequestDTO);
}
