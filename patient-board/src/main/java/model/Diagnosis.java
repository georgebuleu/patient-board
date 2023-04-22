package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "diagnosis")
    private List<Treatment> treatments;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
