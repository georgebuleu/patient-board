package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    private final HospitalRepository hospitalRepository;

    public SpecialtyServiceImpl(HospitalRepository hospitalRepository) {
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
}
