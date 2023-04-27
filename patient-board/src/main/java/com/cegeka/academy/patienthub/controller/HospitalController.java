package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.service.HospitalService;
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

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{hospitalID}/specialties")
    public ResponseEntity<List<String>> getHospitalSpecialties(@PathVariable("hospitalID") Long hospitalID) {
        List<String> specialties= hospitalService.getHospitalSpecialties(hospitalID)
                                                 .stream()
                                                 .map(Speciality::getName)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok().body(specialties);
    }
}
