package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Speciality;

import java.util.List;

public interface HospitalService {

    List<Speciality> getHospitalSpecialties(Long hospitalId);
}
