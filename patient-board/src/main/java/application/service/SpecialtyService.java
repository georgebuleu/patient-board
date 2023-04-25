package application.service;

import application.model.Speciality;

import java.util.List;

public interface SpecialtyService {

    List<Speciality> getHospitalSpecialties(Long hospitalId);

}
