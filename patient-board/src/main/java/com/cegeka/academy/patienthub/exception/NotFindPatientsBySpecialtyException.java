package com.cegeka.academy.patienthub.exception;

public class NotFindPatientsBySpecialtyException extends RuntimeException{
    public NotFindPatientsBySpecialtyException() {
        super("There are no patients for this specialization");
    }
}
