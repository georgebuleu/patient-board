package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.service.SpecialtyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("hospital/{hospitalID}/specialties")
    public ResponseEntity<List<SpecialtyDTO>> getHospitalSpecialties(@PathVariable("hospitalID") Long hospitalID) {

        return ResponseEntity.ok().body(specialtyService.getHospitalSpecialtiesIdAndName(hospitalID));
    }
}
