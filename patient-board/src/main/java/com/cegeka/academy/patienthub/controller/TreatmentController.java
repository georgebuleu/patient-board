package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.GetPatientByHospitalDTO;
import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Treatment;
import com.cegeka.academy.patienthub.service.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {
    private TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/patients/{patient_id}")
    public ResponseEntity<List<TreatmentDTO>> getAllTreatments(@PathVariable("patient_id") Long patient_id) {
        return ResponseEntity.ok().body(treatmentService.getAllTreatments(patient_id));
    }

    @PostMapping("/treatment")
    public void save(@RequestBody TreatmentDTO treatment) {
        treatmentService.create(treatment);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody TreatmentDTO treatment, @PathVariable Long id) {
        treatmentService.update(id, treatment);
    }
}
