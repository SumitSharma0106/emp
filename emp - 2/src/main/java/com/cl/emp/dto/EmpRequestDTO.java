package com.cl.emp.dto;

import com.cl.emp.model.EmpDetails;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class EmpRequestDTO  implements Serializable {


    @Serial
    private static final long serialVersionUID = -6075567582013751485L;
    private String name;
    private String email;
    private String jobTitle;
    private EmpDetails empDetails;
}
