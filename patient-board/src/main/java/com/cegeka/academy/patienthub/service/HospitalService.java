package com.cegeka.academy.patienthub.service;


import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.model.Hospital;
import java.util.Optional;
import java.util.List;

public interface HospitalService {

    List<Speciality> getHospitalSpecialties(Long hospitalId);

    Optional<Hospital> getHospitalByUser(Long userId);

}
