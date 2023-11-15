package org.api.serasa.mvc.service;

import org.api.serasa.dto.consult.ConsultRequestDTO;
import org.api.serasa.dto.consult.ConsultResponseDTO;
import org.api.serasa.mapper.ConsultMapper;
import org.api.serasa.model.ConsultModel;
import org.api.serasa.mvc.repository.ConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultService {

    @Autowired
    private ConsultRepository consultRepository;

    @Autowired
    private ConsultMapper consultMapper;

    public ConsultResponseDTO createConsult(ConsultRequestDTO consultRequest) {
        try {
            ConsultModel consultModel = consultMapper.convertToEntity(consultRequest);
            ConsultModel savedConsult = consultRepository.save(consultModel);
            return consultMapper.convertToDTO(savedConsult);
        } catch (Exception e) {
            throw new RuntimeException("Error creating Consult", e);
        }
    }

    public ConsultResponseDTO updateConsult(Long consultId, ConsultRequestDTO updatedConsultRequest) {
        try {
            ConsultModel existingConsult = consultRepository.findById(consultId)
                    .orElseThrow(() -> new RuntimeException("Consult not found"));

            consultMapper.updateEntityFromDTO(existingConsult, updatedConsultRequest);

            ConsultModel updatedConsult = consultRepository.save(existingConsult);
            return consultMapper.convertToDTO(updatedConsult);
        } catch (Exception e) {
            throw new RuntimeException("Error updating Consult", e);
        }
    }

    public void deleteConsult(Long consultId) {
        try {
            consultRepository.deleteById(consultId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting Consult", e);
        }
    }

    public ConsultResponseDTO getConsultById(Long consultId) {
        try {
            return consultRepository.findById(consultId)
                    .map(consultMapper::convertToDTO)
                    .orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Consult", e);
        }
    }
}
