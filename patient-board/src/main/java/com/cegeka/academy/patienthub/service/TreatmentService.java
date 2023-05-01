package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.TreatmentDTO;
import com.cegeka.academy.patienthub.model.Treatment;

import java.util.Optional;

public interface TreatmentService {
    void create(TreatmentDTO treatment);
    Treatment update(Long id, TreatmentDTO newTreatment);
}
