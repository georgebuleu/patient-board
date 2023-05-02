package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.User;
import com.cegeka.academy.patienthub.repository.HospitalStaffRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalStaffServiceImpl implements HospitalStaffService{
    private final HospitalStaffRepository hospitalStaffRepository;

    public HospitalStaffServiceImpl(HospitalStaffRepository hospitalStaffRepository) {
        this.hospitalStaffRepository = hospitalStaffRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return hospitalStaffRepository.getByEmail(email)
                .map(hospitalStaff -> new User(hospitalStaff.getEmail(), hospitalStaff.getPassword()));

    }

}
