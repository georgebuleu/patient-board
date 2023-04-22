package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;
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
