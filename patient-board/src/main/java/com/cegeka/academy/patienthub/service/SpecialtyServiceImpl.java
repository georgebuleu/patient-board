package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.SpecialtyDTO;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
        return specialtyRepository.findSpecialtiesByHospitalId(hospitalId);
    }

    @Override
    public List<SpecialtyDTO> getHospitalSpecialtiesIdAndName(Long hospitalId) {
        List<Speciality> specialities = specialtyRepository.findSpecialtiesByHospitalId(hospitalId);

        return specialities.stream()
                .map(speciality -> new SpecialtyDTO(speciality.getId(), speciality.getName()))
                .collect(Collectors.toList());
    }
}
