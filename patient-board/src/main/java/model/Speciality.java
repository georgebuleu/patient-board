package model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialityID;
    @Nonnull
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Hospital> hospitals;
    @OneToMany(mappedBy = "speciality")
    private List<Room> rooms;

    public Speciality() {
    }

    public Speciality(String name) {
        this.name = name;
    }

    public Long getSpecialityID() {
        return specialityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
