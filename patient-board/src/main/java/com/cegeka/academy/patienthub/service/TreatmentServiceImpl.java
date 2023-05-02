package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Diagnosis;
import com.cegeka.academy.patienthub.model.Treatment;
import com.cegeka.academy.patienthub.repository.DiagnosisRepository;
import com.cegeka.academy.patienthub.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    TreatmentRepository treatmentRepository;
    private DiagnosisRepository diagnosisRepository;

    public TreatmentServiceImpl(TreatmentRepository treatmentRepository, DiagnosisRepository diagnosisRepository) {
        this.treatmentRepository = treatmentRepository;
        this.diagnosisRepository = diagnosisRepository;
    }


    @Override
    public void create(TreatmentDTO treatmentDTO) {
        Treatment treatment = new Treatment();
        treatment.setTreatmentId(treatmentDTO.getTreatmentId());
        treatment.setTreatment(treatmentDTO.getTreatment());
        treatment.setEvolution(treatmentDTO.getEvolution());
        treatment.setFromDate(treatmentDTO.getFromDate());
        treatment.setToDate(treatmentDTO.getToDate());
        Diagnosis diagnosis = diagnosisRepository.findById(treatmentDTO.getDiagnosisId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Diagnosis Id"));
        treatment.setDiagnosis(diagnosis);
        treatmentRepository.save(treatment);
    }

    @Override
    public Treatment update(Long id, TreatmentDTO newTreatment) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Treatment not found with id " + id));
        treatment.setTreatment(newTreatment.getTreatment());
        treatment.setEvolution(newTreatment.getEvolution());
        treatment.setFromDate(newTreatment.getFromDate());
        treatment.setToDate(newTreatment.getToDate());
        return treatmentRepository.save(treatment);
    }

}
