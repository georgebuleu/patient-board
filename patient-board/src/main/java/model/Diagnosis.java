package model;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String initialDiagnosis;
    private String diagnosisAfter72Hours;
    private String finalDiagnosis;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}
