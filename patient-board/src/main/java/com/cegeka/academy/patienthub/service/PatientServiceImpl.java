package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.GetPatientByHospitalDTO;
import com.cegeka.academy.patienthub.DTO.PatientDTO;
import com.cegeka.academy.patienthub.exception.NotFindPatientsBySpecialtyException;
import com.cegeka.academy.patienthub.model.Patient;
import org.springframework.stereotype.Service;
import com.cegeka.academy.patienthub.repository.PatientRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    final private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<GetPatientByHospitalDTO> getAllPatientsByHospitalIdAndSpecialityId(Long hospitalId, Long specialityId) {
        List<Patient> patients = patientRepository.getAllPatientsByHospitalIdAndSpecialityId(hospitalId,specialityId);
        List<GetPatientByHospitalDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOs.add(new GetPatientByHospitalDTO(patient.getPatientID(),patient.getName(), patient.getRoom().getRoomName()));
        }
        return patientDTOs;
    }

    @Override
    public List<GetPatientByHospitalDTO> getAllPatientsByHospitalId(Long hospitalId) {
        List<Patient> patients = patientRepository.getAllPatientsByHospitalId(hospitalId);
        List<GetPatientByHospitalDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOs.add(new GetPatientByHospitalDTO(patient.getPatientID(), patient.getName(), patient.getRoom().getRoomName()));
        }
        return patientDTOs;
    }

    @Override
    public void create(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setSex(patientDTO.getSex());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setCnp(patientDTO.getCnp());
        patient.setSeriesAndNumber(patientDTO.getSeriesAndNumber());
        patient.setStatusOfInsured(patientDTO.getStatusOfInsured());
        patient.setTypeOfAdmission(patientDTO.getTypeOfAdmission());
        patient.setTypeOfInsurance(patientDTO.getTypeOfInsurance());

        patientRepository.save(patient);

    }

    @Override
    public Patient update(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                          .orElseThrow(() -> new RuntimeException("Patient with " + id +" was not found"));

        patient.setName(patientDTO.getName());
        patient.setSex(patientDTO.getSex());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setAddress(patientDTO.getAddress());
        patient.setCnp(patientDTO.getCnp());
        patient.setSeriesAndNumber(patientDTO.getSeriesAndNumber());
        patient.setStatusOfInsured(patientDTO.getStatusOfInsured());
        patient.setTypeOfAdmission(patientDTO.getTypeOfAdmission());
        patient.setTypeOfInsurance(patientDTO.getTypeOfInsurance());

        return patientRepository.save(patient);

    }

}
