package com.cegeka.academy.patienthub.service;


import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.model.Hospital;
import java.util.Optional;
import java.util.List;

public interface HospitalService {

    Optional<Hospital> getHospitalByUser(Long userId);

}
