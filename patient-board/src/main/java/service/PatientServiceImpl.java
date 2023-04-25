package service;

import model.Patient;
import org.springframework.stereotype.Service;
import repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    final private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatientsBySpecialty(Long specialtyId){
        return patientRepository.findAllPatientsBySpecialtyId(specialtyId);
    }
}
