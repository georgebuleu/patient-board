package model;

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
    @OneToMany(mappedBy = "patient")
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
}
