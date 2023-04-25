package application.service;


import application.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    final private SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<Speciality> getHospitalSpecialties(Long hospitalId) {
//        return specialtyRepository.findByHospitalId(hospitalId);
        return null;
    }

}
