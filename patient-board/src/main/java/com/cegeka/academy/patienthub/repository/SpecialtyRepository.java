package com.cegeka.academy.patienthub.repository;


import com.cegeka.academy.patienthub.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Speciality, Long> {

    List<Speciality> findByHospitalId(Long hospitalId);

}
