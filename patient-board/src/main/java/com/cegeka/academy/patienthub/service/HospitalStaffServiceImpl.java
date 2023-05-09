package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.HospitalStaffDTO;
import com.cegeka.academy.patienthub.DTO.User;
import com.cegeka.academy.patienthub.model.Function;
import com.cegeka.academy.patienthub.model.HospitalStaff;
import com.cegeka.academy.patienthub.model.Speciality;
import com.cegeka.academy.patienthub.repository.FunctionRepository;
import com.cegeka.academy.patienthub.repository.HospitalStaffRepository;
import com.cegeka.academy.patienthub.repository.SpecialtyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalStaffServiceImpl implements HospitalStaffService{
    private final HospitalStaffRepository hospitalStaffRepository;
    private final FunctionRepository functionRepository;
    private final SpecialtyRepository specialtyRepository;

    public HospitalStaffServiceImpl(HospitalStaffRepository hospitalStaffRepository, FunctionRepository functionRepository,
                                    SpecialtyRepository specialtyRepository) {
        this.hospitalStaffRepository = hospitalStaffRepository;
        this.functionRepository = functionRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return hospitalStaffRepository.getByEmail(email)
                .map(hospitalStaff -> new User(hospitalStaff.getEmail(), hospitalStaff.getPassword()));

    }

    @Override
    public void register(HospitalStaffDTO hospitalStaffDTO) {
        HospitalStaff hospitalStaff = new HospitalStaff();
        hospitalStaff.setName(hospitalStaffDTO.getName());
        hospitalStaff.setEmail(hospitalStaffDTO.getEmail());
        String hashedPassword = BCrypt.hashpw(hospitalStaffDTO.getPassword(), BCrypt.gensalt());
        hospitalStaff.setPassword(hashedPassword);
        Speciality speciality = specialtyRepository.findById(hospitalStaffDTO.getSpecialityId()).orElseThrow(() -> new EntityNotFoundException("Speciality not found"));
        hospitalStaff.setSpeciality(speciality);
        Function function = functionRepository.findById(hospitalStaffDTO.getFunctionId()).orElseThrow(() -> new EntityNotFoundException("Function not found"));
        hospitalStaff.setFunction(function);
        hospitalStaffRepository.save(hospitalStaff);
    }

    @Override
    public void updatePassword(HospitalStaffDTO hospitalStaffDTO) {

        hospitalStaffRepository.updatePasswordByEmail(hospitalStaffDTO.getEmail(),hospitalStaffDTO.getPassword());

    }

}
