package model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitalspeciality")
public class HospitalSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalspecialityID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalID")
    private Hospital hospitalID;


}
