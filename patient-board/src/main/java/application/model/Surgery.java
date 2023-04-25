package application.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;
import java.sql.Date;

@Entity
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String medicalTeam;
    private String details;
    @Nonnull
    private Date date;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<HospitalStaff> hospitalStaff;

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
