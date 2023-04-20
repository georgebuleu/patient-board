package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Surgery {
    @Id
    private Long id;
    private String medicalTeam;
    private String details;
    private Date date;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMedicalTeam() {
        return medicalTeam;
    }

    public void setMedicalTeam(String medicalTeam) {
        this.medicalTeam = medicalTeam;
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
}
