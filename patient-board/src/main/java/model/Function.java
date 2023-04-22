package model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long functionId;
    @OneToMany(mappedBy = "function")
    private List<HospitalStaff> hospitalStaffList;
}
