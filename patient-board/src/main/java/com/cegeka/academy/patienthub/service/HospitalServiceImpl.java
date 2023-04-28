package com.cegeka.academy.patienthub.service;


import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.model.Hospital;
import com.cegeka.academy.patienthub.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class HospitalServiceImpl implements HospitalService{
    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
       return hospitalRepository.findSpecialtiesByHospitalId(hospitalId);
    }

    @Override
    public List<SpecialtyDTO> getHospitalSpecialtiesIdAndName(Long hospitalId) {
        List<Speciality> specialities = hospitalRepository.findSpecialtiesByHospitalId(hospitalId);

        return specialities.stream()
                .map(speciality -> new SpecialtyDTO(speciality.getId(), speciality.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Hospital> getHospitalByUser(Long userId) {
        return hospitalRepository.findByHospitalStaffId(userId);
    }

}
