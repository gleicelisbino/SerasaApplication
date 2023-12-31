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

    ScoreModel convertToEntity(ScoreRequestDTO scoreRequestDTO);

    ScoreResponseDTO convertToScoreResponseDTO(ScoreModel scoreModel);

    void updateEntityFromDTO(@MappingTarget ScoreModel scoreModel, ScoreRequestDTO scoreRequestDTO);
}
