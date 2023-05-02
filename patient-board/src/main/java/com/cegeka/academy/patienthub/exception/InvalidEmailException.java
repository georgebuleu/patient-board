package com.cegeka.academy.patienthub.exception;

public class InvalidEmailException extends FailedAuthenticationException{
    public InvalidEmailException(String message) {
        super(message);
    }
}
