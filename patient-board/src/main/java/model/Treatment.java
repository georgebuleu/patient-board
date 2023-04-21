package model;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentId;

}
