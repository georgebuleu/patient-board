package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.Hospital;
import com.cegeka.academy.patienthub.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    @Query("SELECT h FROM Hospital h "
            + "JOIN h.speciality s "
            + "WHERE s.id IN "
            + "(SELECT hs.speciality.id FROM HospitalStaff hs WHERE hs.hospitalStaffId = :hospitalStaffId)")
    Optional<Hospital> findByHospitalStaffId(@Param("hospitalStaffId") Long hospitalStaffId);

}


