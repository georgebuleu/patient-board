package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.model.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long> {
    Optional<HospitalStaff> getByEmail(String email);
}
