package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.PatientDTO;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("hospitals/{hospitalID}/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatientsByHospitalId(@PathVariable("hospitalID") Long hospitalID) {
        return ResponseEntity.ok().body(patientService.getAllPatientsByHospitalId(hospitalID));
    }

    @GetMapping("hospitals/{hospitalID}/specialities/{specialityID}/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatientsByHospitalIdAndSpecialityId(@PathVariable("hospitalID") Long hospitalID, @PathVariable("specialityID") Long specialityID) {
        return ResponseEntity.ok().body(patientService.getAllPatientsByHospitalIdAndSpecialityId(hospitalID, specialityID));
    }

    @PostMapping("/patient")
    public void save(@RequestBody PatientDTO patientDTO){
        patientService.create(patientDTO);
    }

    @PutMapping("/modify-patient/{id}")
    public void updatePatientDetails(@RequestBody PatientDTO patientDTO, @PathVariable Long id){
        patientService.update(id, patientDTO); }


}
