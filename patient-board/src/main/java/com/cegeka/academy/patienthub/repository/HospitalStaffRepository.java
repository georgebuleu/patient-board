package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long> {
    Optional<HospitalStaff> getByEmail(String email);
}
