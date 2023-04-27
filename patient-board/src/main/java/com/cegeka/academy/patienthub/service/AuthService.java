package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.exception.InvalidEmailException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    boolean authenticate(String email, String password) throws InvalidEmailException;
}
