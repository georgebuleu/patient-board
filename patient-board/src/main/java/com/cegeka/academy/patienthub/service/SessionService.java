package com.cegeka.academy.patienthub.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface SessionService {
    Cookie createSessionCookie(HttpServletRequest request);
    boolean validateSession(HttpServletRequest request, Cookie cookie);
    void destroySession(HttpServletRequest request);
    Optional<Cookie> getSessionCookie(HttpServletRequest request);
}
