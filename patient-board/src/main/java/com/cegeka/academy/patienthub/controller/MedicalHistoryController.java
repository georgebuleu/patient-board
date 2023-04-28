package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.exception.MedicalHistoryException;
import com.cegeka.academy.patienthub.model.MedicalHistory;
import com.cegeka.academy.patienthub.service.MedicalHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("patient/{patientId}")
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @ExceptionHandler(MedicalHistoryException.class)
    @GetMapping("/medical-history")
    public ResponseEntity<MedicalHistory> getMedicalHistory(@PathVariable Long patientId) {
        try {
            MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistoryByPatient(patientId);
            return ResponseEntity.status(200).body(medicalHistory);
        } catch (MedicalHistoryException e) {
            return ResponseEntity.status(404).build();
        }
    }
    @PostMapping("/medical-history")
    public void addMedicalHistory(@RequestBody MedicalHistory medicalHistory, @PathVariable Long patientId) {
        medicalHistoryService.createMedicalHistory(medicalHistory, patientId);
    }

    @PutMapping("/medical-history")
    public void editMedicalHistory(@RequestBody MedicalHistory medicalHistory, @PathVariable Long patientId) {
        medicalHistoryService.editMedicalHistory(medicalHistory, patientId);
    }
}
