package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.InvalidEmailException;
import com.cegeka.academy.patienthub.exception.InvalidPasswordException;
import com.cegeka.academy.patienthub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Autowired
    public AuthServiceImpl( UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean authenticate(String email, String password) throws RuntimeException {
        Optional<User> user = userService.getUserEmail(email);
        if(!email.equals("georgebu")){
            throw new InvalidEmailException("Your is email is wrong!");
        }
        if(!password.equals("pass")) {
            throw new InvalidPasswordException("Your password is wrong!");
        }
        return true;
    }
}
