package com.cegeka.academy.patienthub.DTO;

import com.cegeka.academy.patienthub.model.StatusOfInsured;
import com.cegeka.academy.patienthub.model.TypeOfAdmission;
import com.cegeka.academy.patienthub.model.TypeOfInsurance;

public class PatientDTO {

    private Long patientId;

    private String name;

    private String sex;

    private String birthDate;

    private String address;

    private String cnp;

    private String seriesAndNumber;

    private TypeOfInsurance typeOfInsurance;

    private StatusOfInsured statusOfInsured;

    private TypeOfAdmission typeOfAdmission;

    public PatientDTO(Long patientId, String name, String sex, String birthDate, String address, String cnp,
                      String seriesAndNumber, TypeOfInsurance typeOfInsurance, StatusOfInsured statusOfInsured,
                      TypeOfAdmission typeOfAdmission) {

        this.patientId = patientId;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.cnp = cnp;
        this.seriesAndNumber = seriesAndNumber;
        this.typeOfInsurance = typeOfInsurance;
        this.statusOfInsured = statusOfInsured;
        this.typeOfAdmission = typeOfAdmission;
    }

    public PatientDTO() {
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

    public String getSex() { return sex; }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSeriesAndNumber() {
        return seriesAndNumber;
    }

    public void setSeriesAndNumber(String seriesAndNumber) {
        this.seriesAndNumber = seriesAndNumber;
    }

    public TypeOfInsurance getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public StatusOfInsured getStatusOfInsured() {
        return statusOfInsured;
    }

    public void setStatusOfInsured(StatusOfInsured statusOfInsured) {
        this.statusOfInsured = statusOfInsured;
    }

    public TypeOfAdmission getTypeOfAdmission() {
        return typeOfAdmission;
    }

    public void setTypeOfAdmission(TypeOfAdmission typeOfAdmission) {
        this.typeOfAdmission = typeOfAdmission;
    }
}
