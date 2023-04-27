package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
