package com.cegeka.academy.patienthub.exception;

public class InvalidPasswordException extends FailedAuthenticationException{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
