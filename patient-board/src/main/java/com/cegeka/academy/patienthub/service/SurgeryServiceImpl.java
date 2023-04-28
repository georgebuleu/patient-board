package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.SurgeryException;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Surgery;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import com.cegeka.academy.patienthub.repository.SurgeryRepository;
import org.springframework.stereotype.Service;


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
        return surgeryRepository.findByPatientId(patientId)
                .orElseThrow(() -> new SurgeryException("There is no patient linked to this surgery."));
    }

    @Override
    public void addSurgery(Surgery surgery, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new SurgeryException("There is no patient with this id."));

        surgery.setPatient(patient);
        surgeryRepository.save(surgery);

    }

    @Override
    public void editSurgery(Surgery surgery, Long patientId) {
        Surgery currentSurgery = surgeryRepository.findByPatientId(patientId)
                        .orElseThrow(() -> new SurgeryException("There are no surgeries for this patient"));

        currentSurgery.setDate(surgery.getDate());
        currentSurgery.setDetails(surgery.getDetails());
        surgeryRepository.save(currentSurgery);
    }
}
