package application.service;

import application.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatientsBySpecialty(Long specialtyId);
}
