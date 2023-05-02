package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.DiagnosisDTO;
import com.cegeka.academy.patienthub.model.Diagnosis;
import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Treatment;
import com.cegeka.academy.patienthub.repository.DiagnosisRepository;
import com.cegeka.academy.patienthub.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    private final DiagnosisRepository diagnosisRepository;
    private final PatientRepository patientRepository;


    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository, PatientRepository patientRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Diagnosis> findDiagnosisByPatientId(Long patientId) {
        return diagnosisRepository.findDiagnosisByPatientId(patientId);
    }

    @Override
    public void create(DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setInitialDiagnosis(diagnosisDTO.getInitialDiagnosis());
        diagnosis.setDiagnosisAfter72Hours(diagnosisDTO.getDiagnosisAfter72Hours());
        diagnosis.setFinalDiagnosis(diagnosisDTO.getFinalDiagnosis());
        Patient patient = patientRepository.findById(diagnosisDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Patient Id"));
        diagnosis.setPatient(patient);
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis update(Long id, DiagnosisDTO newDiagnosis) {
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseThrow(() -> new RuntimeException("Diagnosis not found with id " + id));
        diagnosis.setInitialDiagnosis(newDiagnosis.getInitialDiagnosis());
        diagnosis.setDiagnosisAfter72Hours(newDiagnosis.getDiagnosisAfter72Hours());
        diagnosis.setFinalDiagnosis(newDiagnosis.getFinalDiagnosis());
        return diagnosisRepository.save(diagnosis);

    }
}
