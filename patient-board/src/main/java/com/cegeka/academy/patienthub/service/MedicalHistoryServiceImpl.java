package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.MedicalHistoryException;
import com.cegeka.academy.patienthub.model.MedicalHistory;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.repository.MedicalHistoryRepository;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository, PatientRepository patientRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public MedicalHistory getMedicalHistoryByPatient(Long id) {
        return medicalHistoryRepository.findByPatientId(id)
                .orElseThrow(() -> new MedicalHistoryException("No prior medical history for this patient"));
    }

    @Override
    public void createMedicalHistory(MedicalHistory medicalHistory, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new MedicalHistoryException("There is no patient with this id"));

        medicalHistory.setPatient(patient);
        medicalHistoryRepository.save(medicalHistory);

    }

    @Override
    public void editMedicalHistory(MedicalHistory medicalHistory, Long patientId) {
        MedicalHistory currentMedicalHistory = medicalHistoryRepository.findByPatientId(patientId)
                .orElseThrow(() -> new MedicalHistoryException("There is no patient with this id;"));

        currentMedicalHistory.setDiseaseHistory(medicalHistory.getDiseaseHistory());
        currentMedicalHistory.setHeredoColHistory(medicalHistory.getHeredoColHistory());
        currentMedicalHistory.setBehaviours(medicalHistory.getBehaviours());
        currentMedicalHistory.setGeneralExam(medicalHistory.getGeneralExam());
        currentMedicalHistory.setBackgroundMeds(medicalHistory.getBackgroundMeds());
        currentMedicalHistory.setLivingWorkingConditions(medicalHistory.getLivingWorkingConditions());
        medicalHistoryRepository.save(currentMedicalHistory);
    }


}
