package model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long functionId;
    @Column(name = "evolution")
    private String evolution;
    @Column(name = "fromDate")
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
}
