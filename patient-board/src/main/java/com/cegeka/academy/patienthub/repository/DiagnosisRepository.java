package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
