package model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalSpecialityID")
    private HospitalSpeciality hospitalSpecialityFKID;

}
