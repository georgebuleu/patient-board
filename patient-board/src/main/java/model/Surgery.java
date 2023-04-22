package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    private List<HospitalStaff> hospitalStaff;

}
