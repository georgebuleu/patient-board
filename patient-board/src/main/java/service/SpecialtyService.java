package service;

import model.Speciality;

import java.util.List;

public interface SpecialtyService {

    List<Speciality> getHospitalSpecialties(Long hospitalId);

}
