package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hospitalStaff")
public class HospitalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalStaffId;
    @ManyToOne
    @JoinColumn(name = "function_id")
    private Function function;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Surgery> surgeries;
}
