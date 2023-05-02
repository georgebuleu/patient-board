package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {

    @Query("select s from Surgery s where s.patient.patientID = :id")
    Optional<Surgery> findByPatientId(@Param("id") Long id);

}
