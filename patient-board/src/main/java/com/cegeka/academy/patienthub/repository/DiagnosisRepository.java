package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

    @Query("SELECT d FROM Diagnosis d where d.patient.patientID = :patientID")
    List<Diagnosis> findDiagnosisByPatientId(@Param("patientID") Long patientId);

}