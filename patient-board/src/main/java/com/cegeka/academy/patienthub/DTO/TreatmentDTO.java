package com.cegeka.academy.patienthub.DTO;

import java.util.Date;

public class TreatmentDTO {
    private Long treatmentId;
    private String treatment;
    private String evolution;
    private Date fromDate;
    private Date toDate;
    private Long diagnosisId;

    public TreatmentDTO() {
    }

    public TreatmentDTO(Long treatmentId, String treatment,
                        String evolution, Date fromDate, Date toDate, Long diagnosisId) {
        this.treatmentId = treatmentId;
        this.treatment = treatment;
        this.evolution = evolution;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.diagnosisId = diagnosisId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
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

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }
}
