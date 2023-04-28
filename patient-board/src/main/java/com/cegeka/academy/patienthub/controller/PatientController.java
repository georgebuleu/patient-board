package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/hospitals/{hospitalID}")
    public ResponseEntity<List<String>> getAllPatientsByHospitalId(@PathVariable("hospitalID") Long hospitalID) {
        List<Long> patients = patientService.getAllPatientsByHospitalId(hospitalID)
                .stream()
                .map(Patient::getPatientID)
                .toList();
        if (patients.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok().body(patients.stream().map(String::valueOf).collect(Collectors.toList()));
        }
    }
    @GetMapping("/hospitals/{hospitalID}/specialities/{specialityID}")
    public ResponseEntity<List<String>> getAllPatientsByHospitalIdAndSpecialityId(@PathVariable("hospitalID") Long hospitalID, @PathVariable("specialityID") Long specialityID) {
        List<Long> patients = patientService.getAllPatientsByHospitalIdAndSpecialityId(hospitalID, specialityID)
                .stream()
                .map(Patient::getPatientID)
                .toList();
        if (patients.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok().body(patients.stream().map(String::valueOf).collect(Collectors.toList()));
        }
    }
}
