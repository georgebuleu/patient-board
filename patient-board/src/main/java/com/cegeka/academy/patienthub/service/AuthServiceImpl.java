package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.exception.InvalidEmailException;
import com.cegeka.academy.patienthub.exception.InvalidPasswordException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {
    private final HospitalStaffServiceImpl hospitalStaffService;
    private final Logger logger = Logger.getLogger("AuthServiceImpl");

    public AuthServiceImpl(HospitalStaffServiceImpl hospitalStaffService) {
        this.hospitalStaffService = hospitalStaffService;
    }

    @Override
    public boolean authenticate(User user) throws RuntimeException {
        User currentUser = hospitalStaffService.getUserByEmail(user.getEmail());
        if(!user.getEmail().trim().equals(currentUser.getEmail()) || user.getEmail().isEmpty()){
            throw new InvalidEmailException("Your is email is wrong!");
        }
        if(!user.getPassword().trim().equals(currentUser.getPassword()) || user.getPassword().isEmpty()) {
            throw new InvalidPasswordException("Your password is wrong!");
        }
        return true;
    }
}
