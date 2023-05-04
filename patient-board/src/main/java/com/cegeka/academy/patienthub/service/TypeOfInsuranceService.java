package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.TypeOfInsurance;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeOfInsuranceService {

    public List<String> getAllTypesOfInsurance(){

        return Arrays.stream(TypeOfInsurance.values())
                .map(TypeOfInsurance::getValue)
                .collect(Collectors.toList());

    }

}
