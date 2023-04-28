package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.exception.SurgeryException;
import com.cegeka.academy.patienthub.model.Surgery;
import com.cegeka.academy.patienthub.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient/{patientId}")
public class SurgeryController {
    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping("/surgery")
    public ResponseEntity<Surgery> getSurgeries(@PathVariable Long patientId) {
        try {
            Surgery surgery = surgeryService.getByPatientId(patientId);
            return ResponseEntity.status(200).body(surgery);
        } catch (SurgeryException e) {
            return ResponseEntity.status(404).build();
        }
    }
    @PostMapping("/surgery")
    public void addSurgery(@PathVariable Long patientId, @RequestBody Surgery surgery) {
        surgeryService.addSurgery(surgery, patientId);
    }

    @PutMapping("/surgery")
    public void editSurgery(@PathVariable Long patientId, @RequestBody Surgery surgery){
        surgeryService.editSurgery(surgery, patientId);
    }
}
