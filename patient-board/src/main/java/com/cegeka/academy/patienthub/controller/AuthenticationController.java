package com.cegeka.academy.patienthub.controller;

import com.cegeka.academy.patienthub.dto.User;
import com.cegeka.academy.patienthub.service.AuthService;
import com.cegeka.academy.patienthub.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/patient-hub")
public class AuthenticationController {
    private final AuthService authService;
    private final SessionService sessionService;
    private final Logger logger = Logger.getLogger("AuthenticationController");
    @Autowired
    public AuthenticationController(AuthService authService, SessionService sessionService) {
        this.authService = authService;
        this.sessionService = sessionService;
    }

    @GetMapping("/login")
    public String accesLogin(){
        return "*THE LOGIN PAGE*";
    }

    @ExceptionHandler(RuntimeException.class)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
        try {
            authService.authenticate(user);
            response.addCookie(sessionService.createSessionCookie(request));
            return ResponseEntity.status(HttpStatus.OK).body("LoginSuccessful");
        } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
    @GetMapping
    public String home(){
        return "*HOME PAGE*";
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request ){
        Cookie sessionCookie = sessionService.getSessionCookie(request);
        sessionService.destroySession(request, sessionCookie );
        return ResponseEntity.status(HttpStatus.OK).body("You have been logged out");
    }
}
