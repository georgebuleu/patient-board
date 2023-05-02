package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

    @Query("SELECT mh FROM MedicalHistory mh JOIN mh.patient p WHERE p.patientID = :patientId")
    Optional<MedicalHistory> findByPatientId(@Param("patientId") Long patientId);

}
