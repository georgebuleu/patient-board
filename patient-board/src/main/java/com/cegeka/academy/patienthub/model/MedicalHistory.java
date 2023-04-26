package com.cegeka.academy.patienthub.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicalHistory")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalHistoryID;

    @Column
    private String heredoColHistory;

    @Column
    @Nonnull
    private String livingWorkingConditions;

    @Column
    @Nonnull
    private String behaviours ;

    @Column
    private String backgroundMeds;

    @Column
    private String diseaseHistory;

    @Column
    @Nonnull
    private String generalExam;

    public MedicalHistory() { }

    public MedicalHistory(Long medicalHistoryID, String heredoColHistory, String livingWorkingConditions, String behaviours,
                          String backgroundMeds, String diseaseHistory, String generalExam) {

        this.medicalHistoryID = medicalHistoryID;
        this.heredoColHistory = heredoColHistory;
        this.livingWorkingConditions = livingWorkingConditions;
        this.behaviours = behaviours;
        this.backgroundMeds = backgroundMeds;
        this.diseaseHistory = diseaseHistory;
        this.generalExam = generalExam;
    }

    public Long getMedicalHistoryID() {
        return medicalHistoryID;
    }

    public void setMedicalHistoryID(Long medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public String getHeredoColHistory() {
        return heredoColHistory;
    }

    public void setHeredoColHistory(String heredoColHistory) {
        this.heredoColHistory = heredoColHistory;
    }

    public String getLivingWorkingConditions() {
        return livingWorkingConditions;
    }

    public void setLivingWorkingConditions(String livingWorkingConditions) {
        this.livingWorkingConditions = livingWorkingConditions;
    }

    public String getBehaviours() {
        return behaviours;
    }

    public void setBehaviours(String behaviours) {
        this.behaviours = behaviours;
    }

    public String getBackgroundMeds() {
        return backgroundMeds;
    }

    public void setBackgroundMeds(String backgroundMeds) {
        this.backgroundMeds = backgroundMeds;
    }

    public String getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public String getGeneralExam() {
        return generalExam;
    }

    public void setGeneralExam(String generalExam) {
        this.generalExam = generalExam;
    }


}
