package org.api.serasa.mapper;

import org.api.serasa.dto.CustomerRequestDTO;
import org.api.serasa.dto.CustomerResponseDTO;
import org.api.serasa.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerModel convertToEntity(CustomerRequestDTO customerRequestDTO);

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "birthdayDate", source = "birthdayDate")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    CustomerResponseDTO convertToDTO(CustomerModel customerModel);

    void updateEntityFromDTO(@MappingTarget CustomerModel customerModel, CustomerRequestDTO customerRequestDTO);
}
