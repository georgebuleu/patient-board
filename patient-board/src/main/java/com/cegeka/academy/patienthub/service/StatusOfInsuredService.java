package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.StatusOfInsured;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusOfInsuredService {

    public List<String> getAllStatusesOfInsured(){
        return Arrays.stream(StatusOfInsured.values())
                .map(StatusOfInsured::getValue)
                .collect(Collectors.toList());
    }

}
