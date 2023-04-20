package model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalspecialityID")
    private HospitalSpeciality hospitalspecialityID;

}
