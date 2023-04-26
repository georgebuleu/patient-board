package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Hospital;
import com.cegeka.academy.patienthub.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @Query("SELECT h.speciality FROM Hospital h WHERE h.id = :hospitalId")
    List<Speciality> findSpecialtiesByHospitalId(@Param("hospitalId") Long hospitalId);

}
