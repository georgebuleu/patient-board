package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentId;
    @NotNull
    @Column(name = "treatment")
    private String treatment;
    @NotNull
    @Column(name = "evolution")
    private String evolution;
    @NotNull
    @Column(name = "fromDate")
    private Date fromDate;
    @NotNull
    @Column(name = "toDate")
    private Date toDate;

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
}
