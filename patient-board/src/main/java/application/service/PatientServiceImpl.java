package application.service;

import application.exception.NotFindPatientsBySpecialtyException;
import application.model.Patient;
import org.springframework.stereotype.Service;
import application.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    final private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatientsBySpecialty(Long specialtyId){
        List<Patient> patients = patientRepository.findAllPatientsBySpecialtyId(specialtyId);
        if(patients.isEmpty()){
                throw new NotFindPatientsBySpecialtyException();

        }else
        return patients;
    }
}
