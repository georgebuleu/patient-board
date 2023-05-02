package com.cegeka.academy.patienthub.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {
    private final static String SESSION_COOKIE = "JSESSIONID";
    @Override
    public Cookie createSessionCookie(HttpServletRequest request) {
        Optional<Cookie> sessionCookie = getSessionCookie(request);
        if(sessionCookie.isPresent() && validateSession(request, sessionCookie.get()))
        {
            return sessionCookie.get();
        }
        String sessionId = request.getSession().getId();
        Cookie cookie = new Cookie(SESSION_COOKIE, sessionId);
        cookie.setHttpOnly(true);
        cookie.setPath("/patient-hub");
        return cookie;
    }

    @Override
    public boolean validateSession(HttpServletRequest request, Cookie cookie) {
        String sessionId = request.getSession().getId();
        return cookie.getName().equals(SESSION_COOKIE) && cookie.getValue().equals(sessionId);
    }

    @Override
    public void destroySession(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("JSESSIONID".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                request.getSession().invalidate();
                return;
            }
        }
    }
    @Override
    public Optional<Cookie> getSessionCookie(HttpServletRequest request){
        Optional<Cookie> optional = Optional.empty();
        if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("JSESSIONID".equals(cookie.getName())) {
                    optional = Optional.of(cookie);
                    break;
                }
            }
        }
        return optional;
    }



}
