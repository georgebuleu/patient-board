package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Hospital;

import java.util.Optional;

public interface HospitalService {
    Optional<Hospital> getHospitalByUser(Long userId);
}
