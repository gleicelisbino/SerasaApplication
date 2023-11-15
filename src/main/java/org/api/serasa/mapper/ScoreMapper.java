package org.api.serasa.mapper;

import org.api.serasa.dto.score.ScoreRequestDTO;
import org.api.serasa.dto.score.ScoreResponseDTO;
import org.api.serasa.model.ScoreModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScoreMapper {

    ScoreMapper INSTANCE = Mappers.getMapper(ScoreMapper.class);

    ScoreModel convertToEntity(ScoreRequestDTO scoreRequestDTO);

    @Mapping(target = "points", source = "points")
    @Mapping(target = "customerModel", source = "customerModel")
    ScoreResponseDTO convertToScoreResponseDTO(ScoreModel scoreModel);

    void updateEntityFromDTO(@MappingTarget ScoreModel scoreModel, ScoreRequestDTO scoreRequestDTO);
}
