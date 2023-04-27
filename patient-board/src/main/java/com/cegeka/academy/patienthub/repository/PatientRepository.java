package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Patient;
import com.cegeka.academy.patienthub.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p JOIN p.room r JOIN r.speciality s JOIN s.hospitals h WHERE h.id = :hospitalId AND s.id = :specialityId")
    List<Patient> getAllPatientsByHospitalIdAndSpecialityId(Long hospitals_id, Long specialityId);


    List<Patient> findAllPatientsBySpecialtyId(@Param("specialtyId") Long specialtyId);
}
