package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Hospital;

public interface HospitalService {
    Hospital getHospitalByUser(Long userId);
}
