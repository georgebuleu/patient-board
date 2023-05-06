package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.service.TypeOfInsuranceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TypeOfInsuranceController {

    private final TypeOfInsuranceService typeOfInsuranceService;

    public TypeOfInsuranceController(TypeOfInsuranceService typeOfInsuranceService) {
        this.typeOfInsuranceService = typeOfInsuranceService;
    }

    @GetMapping("/type-of-insurance")
    public List<String> getAllInsuranceTypes(){
        return typeOfInsuranceService.getAllTypesOfInsurance();
    }


}
