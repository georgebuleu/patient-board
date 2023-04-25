package application.repository;

import application.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.room.speciality.hospitalspeciality.hospitalID = :hospitalId")
    List<Patient> findPatientsByHospitalId(@Param("hospitalId") Long hospitalId);
}