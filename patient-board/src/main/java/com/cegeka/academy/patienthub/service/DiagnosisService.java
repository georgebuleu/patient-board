package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    List<Diagnosis> findDiagnosisByPatientId(Long patientId);


}
