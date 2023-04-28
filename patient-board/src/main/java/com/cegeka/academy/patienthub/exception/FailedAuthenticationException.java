package com.cegeka.academy.patienthub.exception;

public class FailedAuthenticationException extends RuntimeException{
    public FailedAuthenticationException(String message) {
        super(message);
    }
}
