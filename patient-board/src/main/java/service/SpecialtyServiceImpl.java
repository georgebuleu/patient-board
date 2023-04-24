package service;

import model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
        return specialtyRepository.findByHospitalId(hospitalId);
    }

}
