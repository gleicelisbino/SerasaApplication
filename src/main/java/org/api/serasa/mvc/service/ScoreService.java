package org.api.serasa.mvc.service;

import org.api.serasa.dto.score.ScoreRequestDTO;
import org.api.serasa.dto.score.ScoreResponseDTO;
import org.api.serasa.mapper.ScoreMapper;
import org.api.serasa.model.ScoreModel;
import org.api.serasa.mvc.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreMapper scoreMapper;

    public ScoreResponseDTO createScore(ScoreRequestDTO scoreRequest) {
        try {
            ScoreModel scoreModel = scoreMapper.convertToEntity(scoreRequest);
            ScoreModel savedScore = scoreRepository.save(scoreModel);
            return scoreMapper.convertToScoreResponseDTO(savedScore);
        } catch (Exception e) {
            throw new RuntimeException("Error creating Score", e);
        }
    }

    public ScoreResponseDTO updateScore(Long scoreId, ScoreRequestDTO updatedScoreRequest) {
        try {
            ScoreModel existingScore = scoreRepository.findById(scoreId)
                    .orElseThrow(() -> new RuntimeException("Score not found"));

            scoreMapper.updateEntityFromDTO(existingScore, updatedScoreRequest);

            ScoreModel updatedScore = scoreRepository.save(existingScore);
            return scoreMapper.convertToScoreResponseDTO(updatedScore);
        } catch (Exception e) {
            throw new RuntimeException("Error updating Score", e);
        }
    }

    public void deleteScore(Long scoreId) {
        try {
            scoreRepository.deleteById(scoreId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting Score", e);
        }
    }

    public ScoreResponseDTO getScoreById(Long scoreId) {
        try {
            return scoreRepository.findById(scoreId)
                    .map(scoreMapper::convertToScoreResponseDTO)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Score", e);
        }
    }
}
