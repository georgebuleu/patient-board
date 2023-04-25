package service;

import exception.NotFindPatientsBySpecialty;
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
        if(patientRepository.findAllPatientsBySpecialtyId(specialtyId).isEmpty()){
            throw new NotFindPatientsBySpecialty("There are no patients for this specialization");
        }
        return patientRepository.findAllPatientsBySpecialtyId(specialtyId);
    }
}
