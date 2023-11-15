package org.api.serasa.mvc.controller;

import org.api.serasa.dto.score.ScoreRequestDTO;
import org.api.serasa.dto.score.ScoreResponseDTO;
import org.api.serasa.mvc.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/create")
    public ResponseEntity<ScoreResponseDTO> createScore(@RequestBody ScoreRequestDTO scoreRequest) {
        try {
            return new ResponseEntity<>(scoreService.createScore(scoreRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteScore/{scoreId}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long scoreId) {
        try {
            scoreService.deleteScore(scoreId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getScore/{scoreId}")
    public ResponseEntity<ScoreResponseDTO> getScore(@PathVariable Long scoreId) {
        try {
            ScoreResponseDTO scoreResponseDTO = scoreService.getScoreById(scoreId);
            if (scoreResponseDTO != null) {
                return new ResponseEntity<>(scoreResponseDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateScore/{scoreId}")
    public ResponseEntity<ScoreResponseDTO> updateScore(@RequestBody ScoreRequestDTO scoreRequest,
                                                        @PathVariable Long scoreId) {
        try {
            return new ResponseEntity<>(scoreService.updateScore(scoreId, scoreRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
