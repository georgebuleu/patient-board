package com.cegeka.academy.patienthub.service;

import com.cegeka.academy.patienthub.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Override
    public Cookie createSessionCookie(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }

    @Override
    public boolean validateSession(HttpServletRequest request, Cookie cookie) {
        String sessionId = request.getSession().getId();
        return cookie.getName().equals("JSESSIONID") && cookie.getValue().equals(sessionId);
    }

    @Override
    public void destroySession(HttpServletRequest request, Cookie cookie) {
        cookie.setMaxAge(0);
        request.getSession().invalidate();
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
