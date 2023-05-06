package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.service.StatusOfInsuredService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StatusOfInsuredController {

    private final StatusOfInsuredService statusOfInsuredService;

    public StatusOfInsuredController(StatusOfInsuredService statusOfInsuredService) {
        this.statusOfInsuredService = statusOfInsuredService;
    }

    @GetMapping("status-of-insured")
    public List<String> getAllInsuranceStatuses(){
        return statusOfInsuredService.getAllStatusesOfInsured();
    }
}
