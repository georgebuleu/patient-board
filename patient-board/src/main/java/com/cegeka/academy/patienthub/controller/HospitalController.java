package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.service.HospitalService;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final PatientService patientService;
    public HospitalController(HospitalService hospitalService, PatientService patientService) {
        this.hospitalService = hospitalService;
        this.patientService = patientService;
    }

    @GetMapping("/{hospitalID}/specialties")
    public ResponseEntity<List<String>> getHospitalSpecialties(@PathVariable("hospitalID") Long hospitalID) {
        List<String> specialties= hospitalService.getHospitalSpecialties(hospitalID)
                                                 .stream()
                                                 .map(Speciality::getName)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok().body(specialties);
    }

    @GetMapping("/{hospitalID}/patients")
    public ResponseEntity<List<String>> getAllPatientsByHospitalId(@PathVariable("hospitalID") Long hospitalID) {
        List<Long> patients= patientService.getAllPatientsByHospitalId(hospitalID)
                .stream()
                .map(Patient::getPatientID)
                .toList();
        return ResponseEntity.ok().body(patients.stream().map(String::valueOf).collect(Collectors.toList()));
    }
}
