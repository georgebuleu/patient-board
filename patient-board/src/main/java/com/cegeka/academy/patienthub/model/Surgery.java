package com.cegeka.academy.patienthub.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;
import java.sql.Date;

@Entity
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;
    @Nonnull
    private Date date;
    @ManyToMany(mappedBy = "surgeries", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<HospitalStaff> hospitalStaff;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<HospitalStaff> getHospitalStaff() {
        return hospitalStaff;
    }

    public void setHospitalStaff(List<HospitalStaff> hospitalStaff) {
        this.hospitalStaff = hospitalStaff;
    }
}
