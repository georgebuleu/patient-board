package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.exception.SurgeryException;
import com.cegeka.academy.patienthub.model.Surgery;
import com.cegeka.academy.patienthub.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitals/patient/{id}")
public class SurgeryController {
    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping("/surgery")
    public ResponseEntity<Surgery> getSurgeries(@PathVariable Long id) {
        return ResponseEntity.status(200).body(surgeryService.getByPatientId(id));
    }
    @PostMapping("/surgery")
    public void addSurgery(@PathVariable Long id, @RequestBody Surgery surgery) {
        surgeryService.addSurgery(surgery, id);
    }

    @PutMapping("/surgery")
    public void editSurgery(@PathVariable Long id, @RequestBody Surgery surgery){
        surgeryService.editSurgery(surgery, id);
    }
}
