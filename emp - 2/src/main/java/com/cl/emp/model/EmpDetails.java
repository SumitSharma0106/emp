package com.cl.emp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class EmpDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = 5345363797939553145L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String officeAddress;
    private String homeAddress;
    @OneToOne
    @JoinColumn(name = "empId", nullable = false)
    @JsonBackReference(value = "emp-details")
    private Emp empId;
}