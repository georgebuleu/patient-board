package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.PatientDTO;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hospitals/{hospitalID}")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatientsByHospitalId(@PathVariable("hospitalID") Long hospitalID) {
        return ResponseEntity.ok().body(patientService.getAllPatientsByHospitalId(hospitalID));
    }
    @GetMapping("/specialities/{specialityID}/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatientsByHospitalIdAndSpecialityId(@PathVariable("hospitalID") Long hospitalID, @PathVariable("specialityID") Long specialityID) {
        return ResponseEntity.ok().body(patientService.getAllPatientsByHospitalIdAndSpecialityId(hospitalID,specialityID));
    }
}
