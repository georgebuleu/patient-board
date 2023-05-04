package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.service.TypeOfAdmissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TypeOfAdmissionController {

    private final TypeOfAdmissionService typeOfAdmissionService;

    public TypeOfAdmissionController(TypeOfAdmissionService typeOfAdmissionService) {
        this.typeOfAdmissionService = typeOfAdmissionService;
    }

    @GetMapping("/type-of-admissions")
    public List<String> getAllAdmissionsTypes(){
        return typeOfAdmissionService.getAllTypesOfAdmissions();
    }

}
