package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    @Query("SELECT t FROM Treatment t JOIN t.diagnosis.patient p WHERE p.patientID = :patient_id")
    List<Treatment> getAllTreatments(@Param("patient_id") Long patient_id);
}
