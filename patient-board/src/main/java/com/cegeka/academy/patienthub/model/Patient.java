package com.cegeka.academy.patienthub.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;

    @Column
    @Nonnull
    private String name;

    @Column
    private String phone;

    @Column
    private String sex;

    @Column
    private String birthDate;

    @Column
    private String address;

    @Column
    @Nonnull
    private String cnp;

    @Column
    @Nonnull
    private String seriesAndNumber;

    @Column
    @Nonnull
    @Enumerated(EnumType.STRING)
    private TypeOfInsurance typeOfInsurance;

    @Column
    @Nonnull
    @Enumerated(EnumType.STRING)
    private StatusOfInsured statusOfInsured;

    @Column
    @Nonnull
    @Enumerated(EnumType.STRING)
    private TypeOfAdmission typeOfAdmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomID")
    private Room room;

    @OneToOne
    @JoinColumn(name = "medicalHistory_id")
    MedicalHistory medicalHistory;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diagnosis> diagnosis;

    public Patient() {
    }

    public Patient(Long patientID, String name, String phone, String sex, String birthDate, String address, String cnp,
                   String seriesAndNumber, Room room, MedicalHistory medicalHistory, List<Diagnosis> diagnosis,
                   TypeOfInsurance typeOfInsurance, StatusOfInsured statusOfInsured, TypeOfAdmission typeOfAdmission) {
        this.patientID = patientID;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.cnp = cnp;
        this.seriesAndNumber = seriesAndNumber;
        this.room = room;
        this.medicalHistory = medicalHistory;
        this.diagnosis = diagnosis;
        this.typeOfInsurance = typeOfInsurance;
        this.statusOfInsured = statusOfInsured;
        this.typeOfAdmission = typeOfAdmission;
    }

    public Long getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @JsonManagedReference
    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
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
