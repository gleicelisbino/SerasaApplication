package org.api.serasa.mapper;

import org.api.serasa.dto.consult.ConsultRequestDTO;
import org.api.serasa.dto.consult.ConsultResponseDTO;
import org.api.serasa.model.ConsultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultMapper {

    ConsultModel convertToEntity(ConsultRequestDTO consultRequestDTO);

    @Mapping(target = "dataConsult", source = "dataConsult")
    @Mapping(target = "customerModel", source = "customerModel")
    ConsultResponseDTO convertToDTO(ConsultModel consultModel);

    List<ConsultResponseDTO> convertToDTOList(List<ConsultModel> consultModels);

    void updateEntityFromDTO(@MappingTarget ConsultModel consultModel, ConsultRequestDTO consultRequestDTO);
}
