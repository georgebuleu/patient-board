package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.exception.InvalidEmailException;
import com.cegeka.academy.patienthub.model.HospitalStaff;
import com.cegeka.academy.patienthub.repository.HospitalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalStaffServiceImpl implements HospitalStaffService{
    private final HospitalStaffRepository hospitalStaffRepository;

    public HospitalStaffServiceImpl(HospitalStaffRepository hospitalStaffRepository) {
        this.hospitalStaffRepository = hospitalStaffRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<HospitalStaff> hospitalStaff = hospitalStaffRepository.getByEmail(email);
       if(hospitalStaff.isEmpty())
           throw new InvalidEmailException("Email does not exist!");

       return new User(hospitalStaff.get().getEmail(), hospitalStaff.get().getPassword());
    }
}
