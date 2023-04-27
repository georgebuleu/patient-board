package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.MedicalHistoryException;
import com.cegeka.academy.patienthub.model.MedicalHistory;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.repository.MedicalHistoryRepository;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService{

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository, PatientRepository patientRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public MedicalHistory getMedicalHistoryByPatient(Long id) {
        Optional<MedicalHistory> medicalHistory = medicalHistoryRepository.findByPatientId(id);
       if(medicalHistory.isEmpty()) {
           throw new MedicalHistoryException("No prior medical history for this patient");
       }
       return medicalHistory.get();
    }

    @Override
    public void createMedicalHistory(MedicalHistory medicalHistory, Long patientId) {
           Optional<Patient> patient = patientRepository.findById(patientId);

           patient.ifPresent(p -> {
               medicalHistory.setPatient(p);
               medicalHistoryRepository.save(medicalHistory);
           });
           if(patient.isEmpty())
               throw new MedicalHistoryException("There is no patient with this id");
    }

    @Override
    public void editMedicalHistory(MedicalHistory medicalHistory, Long patientId) {
        Optional<MedicalHistory> currentMedicalHistory = medicalHistoryRepository.findByPatientId(patientId);

        currentMedicalHistory.ifPresent(history -> {
            history.setDiseaseHistory(medicalHistory.getDiseaseHistory());
            history.setHeredoColHistory(medicalHistory.getHeredoColHistory());
            history.setBehaviours(medicalHistory.getBehaviours());
            history.setGeneralExam(medicalHistory.getGeneralExam());
            history.setBackgroundMeds(medicalHistory.getBackgroundMeds());
            history.setLivingWorkingConditions(medicalHistory.getLivingWorkingConditions());
            medicalHistoryRepository.save(history);
        });



        if(medicalHistoryRepository.findByPatientId(patientId).isEmpty()){
            throw new MedicalHistoryException("There is no patient with this id;");
        }
    }


}
