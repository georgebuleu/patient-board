package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Diagnosis;
import com.cegeka.academy.patienthub.service.DiagnosisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
