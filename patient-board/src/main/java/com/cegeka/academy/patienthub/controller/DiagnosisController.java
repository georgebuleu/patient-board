package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.DiagnosisDTO;
import com.cegeka.academy.patienthub.model.Diagnosis;
import com.cegeka.academy.patienthub.service.DiagnosisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/patients/{patientId}/diagnosis")
    public ResponseEntity<List<Diagnosis>> getPatientDiagnosis(@PathVariable("patientId") Long patientId){
        return ResponseEntity.ok().body(diagnosisService.findDiagnosisByPatientId(patientId));
    }

    @PostMapping("/diagnosis")
    public void save(@RequestBody DiagnosisDTO diagnosisDTO) {
        diagnosisService.create(diagnosisDTO);
    }

    @PutMapping("/diagnosis/{id}")
    public void update(@RequestBody DiagnosisDTO diagnosisDTO, @PathVariable Long id) {
        diagnosisService.update(id, diagnosisDTO);
    }

}
