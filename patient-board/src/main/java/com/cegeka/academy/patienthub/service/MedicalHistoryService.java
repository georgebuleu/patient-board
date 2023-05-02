package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.MedicalHistory;

public interface MedicalHistoryService {
    MedicalHistory getMedicalHistoryByPatient(Long id);
    void createMedicalHistory(MedicalHistory history, Long patientId);
    void editMedicalHistory(MedicalHistory medicalHistory, Long patientId);
}
