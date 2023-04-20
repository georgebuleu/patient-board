package model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicalHistory")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalHistoryID;
}
