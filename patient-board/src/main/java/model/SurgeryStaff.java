package model;

import jakarta.persistence.*;

@Entity
@Table(name = "surgeryStaff")
public class SurgeryStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryStaffId;
}
