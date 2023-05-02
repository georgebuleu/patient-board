package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.model.Speciality;

import java.util.List;

public interface SpecialtyService {

    List<Speciality> getHospitalSpecialties(Long hospitalId);

    List<SpecialtyDTO> getHospitalSpecialtiesIdAndName(Long hospitalId);
}
