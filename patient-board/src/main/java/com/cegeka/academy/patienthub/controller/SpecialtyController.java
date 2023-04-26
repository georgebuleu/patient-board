package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.service.SpecialtyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("/hospitals/{hospitalID}/specialties")
    public List<String> getHospitalSpecialties(@PathVariable("hospitalID") Long hospitalID) {
        return specialtyService.getHospitalSpecialties(hospitalID).stream().map(Speciality::getName).collect(Collectors.toList());
    }
}
