package com.cegeka.academy.patienthub.service;


import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
       return hospitalRepository.findSpecialtiesByHospitalId(hospitalId);
    }

}
