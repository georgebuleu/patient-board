package com.cegeka.academy.patienthub.interceptor;

import com.cegeka.academy.patienthub.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private SessionService sessionService;

    public AuthenticationInterceptor(){}
    @Autowired
    public AuthenticationInterceptor(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<Cookie> sessionCookie = sessionService.getSessionCookie(request);

        if (sessionCookie.isPresent()) {
            if (sessionService.validateSession(request, sessionCookie.get()))
                return true;
        }

        if (request.getRequestURI().equals("/patient-hub/login")) {
            return true;
        }
        response.sendRedirect("/patient-hub/login");
        response.setStatus(401);
        return false;
    }
}
