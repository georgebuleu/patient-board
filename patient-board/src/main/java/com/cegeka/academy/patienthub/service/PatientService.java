package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatientsBySpecialty(Long specialtyId);

    List<Patient> getAllPatientsByHospitalIdAndSpecialityId(Long hospitalId, Long specialityId);
}
