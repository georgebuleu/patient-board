package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentService {

    List<TreatmentDTO> getAllTreatments(Long patient_id);
    void create(TreatmentDTO treatment);
    Treatment update(Long id, TreatmentDTO newTreatment);
}
