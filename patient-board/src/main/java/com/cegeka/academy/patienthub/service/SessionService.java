package com.cegeka.academy.patienthub.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    Cookie createSessionCookie(HttpServletRequest request);
    boolean validateSession(HttpServletRequest request, Cookie cookie);
    void destroySession(HttpServletRequest request, Cookie cookie);
    Cookie getSessionCookie(HttpServletRequest request);
}
