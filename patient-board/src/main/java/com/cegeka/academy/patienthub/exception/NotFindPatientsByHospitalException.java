package com.cegeka.academy.patienthub.exception;

public class NotFindPatientsByHospitalException extends RuntimeException{
    public NotFindPatientsByHospitalException() {
        super("There are no patients for this hospital");
    }
}
