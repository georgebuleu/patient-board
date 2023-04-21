package model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitalStaff")
public class HospitalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalStaffId;
}
