package com.cegeka.academy.patienthub.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import java.util.Date;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentId;
    @NonNull
    @Column(name = "treatment")
    private String treatment;
    @NonNull
    @Column(name = "evolution")
    private String evolution;
    @NonNull
    @Column(name = "fromDate")
    private Date fromDate;
    @NonNull
    @Column(name = "toDate")
    private Date toDate;
    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    public Treatment() {
    }

    public Treatment( String treatment, String evolution, Date fromDate, Date toDate) {
        this.treatment = treatment;
        this.evolution = evolution;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @JsonBackReference
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
