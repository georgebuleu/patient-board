package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
