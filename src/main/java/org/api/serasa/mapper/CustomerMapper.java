package org.api.serasa.mapper;

import org.api.serasa.dto.customer.CustomerRequestDTO;
import org.api.serasa.dto.customer.CustomerResponseDTO;
import org.api.serasa.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerModel convertToEntity(CustomerRequestDTO customerRequestDTO);


    @Mapping(target = "birthdayDate", source = "birthdayDate")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    CustomerResponseDTO convertToDTO(CustomerModel customerModel);

    void updateEntityFromDTO(@MappingTarget CustomerModel customerModel, CustomerRequestDTO customerRequestDTO);
}
