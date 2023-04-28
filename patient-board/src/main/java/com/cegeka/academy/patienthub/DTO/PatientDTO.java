package com.cegeka.academy.patienthub.DTO;

public class PatientDTO {
    private Long patientId;

    private String name;

    public PatientDTO(Long patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getPatientId() {
        return patientId;
    }
}
