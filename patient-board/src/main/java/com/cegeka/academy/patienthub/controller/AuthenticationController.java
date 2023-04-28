package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.exception.FailedAuthenticationException;
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

    @GetMapping("/login")
    public ResponseEntity<String> loginPage(){
        return ResponseEntity.status(401).build();
    }

    @ExceptionHandler(FailedAuthenticationException.class)
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
        try {
            authService.authenticate(user);
            response.addCookie(sessionService.createSessionCookie(request));
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        } catch (FailedAuthenticationException e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    @ExceptionHandler(FailedAuthenticationException.class)
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        sessionService.destroySession(request);
        return ResponseEntity.status(HttpStatus.OK).body("You have been logged out");
    }
}
