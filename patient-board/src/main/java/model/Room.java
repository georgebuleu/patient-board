package model;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;
    private int capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospitalspecialityID")
    private HospitalSpeciality hospitalspecialityID;

    public Long getroomID() {
        return roomID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
