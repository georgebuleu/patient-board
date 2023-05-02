package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.DiagnosisDTO;
import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    List<Diagnosis> findDiagnosisByPatientId(Long patientId);

    void create(DiagnosisDTO diagnosisDTO);

    Diagnosis update(Long id, DiagnosisDTO newDiagnosis);
}
