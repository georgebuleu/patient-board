package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.SurgeryException;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Surgery;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import com.cegeka.academy.patienthub.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService{

    private final SurgeryRepository surgeryRepository;
    private final PatientRepository patientRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository, PatientRepository patientRepository) {
        this.surgeryRepository = surgeryRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Surgery getByPatientId(Long patientId) {
        Optional<Surgery> currentSurgery = surgeryRepository.findByPatientId(patientId);
        if(currentSurgery.isEmpty())
            throw new SurgeryException("There is no patient linked to this surgery.");

        return currentSurgery.get();
    }

    @Override
    public void addSurgery(Surgery surgery, Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);

        patient.ifPresent(p ->{
            surgery.setPatient(p);
            surgeryRepository.save(surgery);
        });
        if(patient.isEmpty())
            throw new SurgeryException("There is no patient with this id.");

    }

    @Override
    public void editSurgery(Surgery surgery, Long patientId) {
        Optional<Surgery> currentSurgery = surgeryRepository.findByPatientId(patientId);

        currentSurgery.ifPresent(s ->{
           s.setDate(surgery.getDate());
           s.setDetails(surgery.getDetails());
           surgeryRepository.save(s);
        });
        if(currentSurgery.isEmpty())
            throw new RuntimeException("There are no surgeries for this patient");
    }
}
