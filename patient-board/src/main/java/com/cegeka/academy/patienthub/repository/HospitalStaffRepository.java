package com.cegeka.academy.patienthub.repository;

import com.cegeka.academy.patienthub.model.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long> {
    Optional<HospitalStaff> getByEmail(String email);

    @Query("UPDATE HospitalStaff SET password = :password WHERE email = :email")
    void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);
}
