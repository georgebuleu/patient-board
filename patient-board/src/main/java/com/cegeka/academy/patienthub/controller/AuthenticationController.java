package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.service.AuthService;
import com.cegeka.academy.patienthub.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/patient-hub")
public class AuthenticationController {
    private final AuthService authService;
    private final SessionService sessionService;

    @Autowired
    public AuthenticationController(AuthService authService, SessionService sessionService) {
        this.authService = authService;
        this.sessionService = sessionService;
    }
    @ExceptionHandler(AuthenticationException.class)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
        try {
            authService.authenticate(user);
            response.addCookie(sessionService.createSessionCookie(request));
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        } catch (AuthenticationException e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        sessionService.destroySession(request);
        return ResponseEntity.status(HttpStatus.OK).body("You have been logged out");
    }
}
