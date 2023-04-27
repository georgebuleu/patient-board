package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.NotFindPatientsByHospitalException;
import com.cegeka.academy.patienthub.exception.NotFindPatientsBySpecialtyException;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.service.PatientService;
import org.springframework.stereotype.Service;
import com.cegeka.academy.patienthub.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    final private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatientsBySpecialty(Long specialtyId) {
        List<Patient> patients = patientRepository.findAllPatientsBySpecialtyId(specialtyId);
        if (patients.isEmpty()) {
            throw new NotFindPatientsBySpecialtyException();

        } else
            return patients;
    }

    @Override
    public List<Patient> getAllPatientsByHospitalIdAndSpecialityId(Long hospitalId, Long specialityId) {
        List<Patient> patients = patientRepository.getAllPatientsByHospitalIdAndSpecialityId(hospitalId, specialityId);
        if (patients.isEmpty()) {
            throw new NotFindPatientsByHospitalException();

        } else
            return patients;
    }

    @Override
    public List<Patient> getAllPatientsByHospitalId(Long hospitalId) {
        List<Patient> patients = patientRepository.getAllPatientsByHospitalId(hospitalId);
        if (patients.isEmpty()) {
            throw new NotFindPatientsByHospitalException();

        } else
            return patients;
    }
}
