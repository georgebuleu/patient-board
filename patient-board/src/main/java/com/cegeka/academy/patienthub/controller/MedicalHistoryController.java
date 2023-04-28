package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.exception.MedicalHistoryException;
import com.cegeka.academy.patienthub.model.MedicalHistory;
import com.cegeka.academy.patienthub.service.MedicalHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("hospitals/patient/{id}")
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @ExceptionHandler(MedicalHistoryException.class)
    @GetMapping("/medical-history")
    public ResponseEntity<MedicalHistory> getMedicalHistory(@PathVariable Long id) {
        MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistoryByPatient(id);
        return ResponseEntity.status(200).body(medicalHistory);
    }
    @PostMapping("/medical-history")
    public void addMedicalHistory(@RequestBody MedicalHistory medicalHistory, @PathVariable Long id) {
        medicalHistoryService.createMedicalHistory(medicalHistory, id);
    }

    @PutMapping("/medical-history")
    public void editMedicalHistory(@RequestBody MedicalHistory medicalHistory, @PathVariable Long id) {
        medicalHistoryService.editMedicalHistory(medicalHistory, id);
    }
}
