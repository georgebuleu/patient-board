package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.PatientDTO;
import com.cegeka.academy.patienthub.model.Patient;

import java.util.List;

public interface PatientService {


    List<PatientDTO> getAllPatientsByHospitalIdAndSpecialityId(Long hospitalId, Long specialityId);

    List<PatientDTO> getAllPatientsByHospitalId(Long hospitalId);

    void create(PatientDTO patientDTO);

    Patient update(Long id, PatientDTO patientDTO);
}
