package model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitalspeciality")
public class HospitalSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalSpecialityID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalID")
    private Hospital hospitalFKID;
    private Long specialityFKID;
}
