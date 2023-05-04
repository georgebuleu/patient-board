package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.TypeOfAdmission;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeOfAdmissionService {

    public List<String> getAllTypesOfAdmissions(){

        return Arrays.stream(TypeOfAdmission.values())
                .map(TypeOfAdmission::getValue)
                .collect(Collectors.toList());

    }


}
