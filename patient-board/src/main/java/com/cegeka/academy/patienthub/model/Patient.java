package com.cegeka.academy.patienthub.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private Integer phone;
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

    public Patient(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
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
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
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

    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnosis> diagnosis) {
        this.diagnosis = diagnosis;
    }
}
