package org.api.serasa.mvc.controller;

import org.api.serasa.dto.consult.ConsultRequestDTO;
import org.api.serasa.dto.consult.ConsultResponseDTO;
import org.api.serasa.mvc.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consult")
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    @PostMapping("/create")
    public ResponseEntity<ConsultResponseDTO> createConsult(@RequestBody ConsultRequestDTO consultRequest) {
        try {
            return new ResponseEntity<>(consultService.createConsult(consultRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteConsult/{consultId}")
    public ResponseEntity<Void> deleteConsult(@PathVariable Long consultId) {
        try {
            consultService.deleteConsult(consultId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getConsult/{consultId}")
    public ResponseEntity<ConsultResponseDTO> getConsult(@PathVariable Long consultId) {
        try {
            ConsultResponseDTO consultResponseDTO = consultService.getConsultById(consultId);
            if (consultResponseDTO != null) {
                return new ResponseEntity<>(consultResponseDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateConsult/{consultId}")
    public ResponseEntity<ConsultResponseDTO> updateConsult(@RequestBody ConsultRequestDTO consultRequest,
                                                            @PathVariable Long consultId) {
        try {
            return new ResponseEntity<>(consultService.updateConsult(consultId, consultRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
