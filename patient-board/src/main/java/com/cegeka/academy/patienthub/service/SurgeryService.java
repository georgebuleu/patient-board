package com.cegeka.academy.patienthub.service;
import com.cegeka.academy.patienthub.model.Surgery;

public interface SurgeryService {
    Surgery getByPatientId( Long patientId);
    void addSurgery(Surgery surgery, Long patientId);
    void editSurgery(Surgery surgery, Long patientId);
}
