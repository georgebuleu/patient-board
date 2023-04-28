package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.dto.User;

import javax.naming.AuthenticationException;

public interface AuthService {

    void authenticate(User user) throws AuthenticationException;
}
