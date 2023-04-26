package com.cegeka.academy.patienthub.service;


import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cegeka.academy.patienthub.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    final private SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
       return specialtyRepository.findByHospitalId(hospitalId);
    }

}
