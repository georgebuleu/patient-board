package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.DTO.HospitalStaffDTO;
import com.cegeka.academy.patienthub.service.HospitalStaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitalStaff")
public class HospitalStaffController {
    private final HospitalStaffService hospitalStaffService;

    public HospitalStaffController(HospitalStaffService hospitalStaffService) {
        this.hospitalStaffService = hospitalStaffService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody HospitalStaffDTO hospitalStaffDTO) {
        hospitalStaffService.register(hospitalStaffDTO);
        return ResponseEntity.ok().build();
    }

}
