package com.cegeka.academy.patienthub.DTO;

public class DiagnosisDTO {
    private Long id;
    private String initialDiagnosis;
    private String diagnosisAfter72Hours;
    private String finalDiagnosis;
    private Long patientId;

    public DiagnosisDTO() {
    }

    public DiagnosisDTO(Long id, String initialDiagnosis, String diagnosisAfter72Hours, String finalDiagnosis, Long patientId) {
        this.id = id;
        this.initialDiagnosis = initialDiagnosis;
        this.diagnosisAfter72Hours = diagnosisAfter72Hours;
        this.finalDiagnosis = finalDiagnosis;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public void setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
    }

    public String getDiagnosisAfter72Hours() {
        return diagnosisAfter72Hours;
    }

    public void setDiagnosisAfter72Hours(String diagnosisAfter72Hours) {
        this.diagnosisAfter72Hours = diagnosisAfter72Hours;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }


}
