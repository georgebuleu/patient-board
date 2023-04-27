package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SessionServiceImpl implements SessionService {
    private final static String SESSION_COOKIE = "JSESSIONID";
    @Override
    public Cookie createSessionCookie(HttpServletRequest request) {
        Cookie sessionCookie = getSessionCookie(request);
        if(sessionCookie != null && validateSession(request, sessionCookie))
        {
            return sessionCookie;
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
    public Cookie getSessionCookie(HttpServletRequest request){
        if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("JSESSIONID".equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
