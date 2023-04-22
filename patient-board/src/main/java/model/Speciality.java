package model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialityID;
    @Nonnull
    private String name;

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
