package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.model.Diagnosis;
import com.cegeka.academy.patienthub.repository.DiagnosisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<Diagnosis> findDiagnosisByPatientId(Long patientId) {
        return diagnosisRepository.findDiagnosisByPatientId(patientId);
    }
}
