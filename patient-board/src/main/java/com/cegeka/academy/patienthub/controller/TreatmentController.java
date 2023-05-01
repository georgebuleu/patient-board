package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Treatment;
import com.cegeka.academy.patienthub.service.TreatmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {
    private TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
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
