package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.DTO.User;
import com.cegeka.academy.patienthub.exception.InvalidEmailException;
import com.cegeka.academy.patienthub.exception.InvalidPasswordException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    private final HospitalStaffServiceImpl hospitalStaffService;

    public AuthServiceImpl(HospitalStaffServiceImpl hospitalStaffService) {
        this.hospitalStaffService = hospitalStaffService;
    }

    @Override
    public void authenticate(User user) {
        Optional<User> currentUser = hospitalStaffService.getUserByEmail(user.email());
        if(currentUser.isEmpty()) {
            throw new InvalidEmailException("There is no such email");
        }
        if(!user.email().trim().equals(currentUser.get().email()) || user.email().isEmpty()){
            throw new InvalidEmailException("Your is email is wrong!");
        }
        if(!user.password().trim().equals(currentUser.get().password()) || user.password().isEmpty()) {
            throw new InvalidPasswordException("Your password is wrong!");
        }
    }
}
