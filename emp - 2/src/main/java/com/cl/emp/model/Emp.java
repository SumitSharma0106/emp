package com.cl.emp.model;

import com.cl.emp.dto.EmpDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "EmployeeMapping",
                classes = @ConstructorResult(
                        targetClass = EmpDto.class,
                        columns = {
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type = String.class),
                                @ColumnResult(name = "jobTitle", type = String.class),
                                @ColumnResult(name="empDetails",type=EmpDetails.class)
                        }
                )
        )
})
public class Emp implements Serializable {


    @Serial
    private static final long serialVersionUID = -4576497776634547196L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String name;
    private String email;
    private String jobTitle;
    @OneToOne(mappedBy = "empId",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "emp")
    @JsonIgnore
    private EmpDetails empDetails;

}
