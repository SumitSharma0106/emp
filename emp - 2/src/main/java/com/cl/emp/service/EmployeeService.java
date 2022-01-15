package com.cl.emp.service;

import com.cl.emp.dto.EmpDto;
import com.cl.emp.dto.EmpRequestDTO;
import com.cl.emp.model.Emp;
import com.cl.emp.model.EmpDetails;
import com.cl.emp.repository.EmpDetailsRepository;
import com.cl.emp.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private EmpDetailsRepository empDetailsRepository;

    public EmpDto getEmpById(Long id){
        EmpDto empDto=new EmpDto();
        Emp empId = empRepository.findByEmpId(id);
        EmpDetails empDetails=empDetailsRepository.findByEmpId(id);
        empDto.setName(empId.getName());
        empDto.setEmail(empId.getEmail());
        empDto.setJobTitle(empId.getJobTitle());
        empDto.setEmpDetails(empDetails);
        return empDto;
    }

    public String saveEmp(EmpRequestDTO empDto){
        Emp emp=new Emp();
        EmpDetails empDetails=empDto.getEmpDetails();
        emp.setName(empDto.getName());
        emp.setEmail(empDto.getEmail());
        emp.setJobTitle(empDto.getJobTitle());
        emp.setEmpDetails(empDto.getEmpDetails());
        empDetails.setEmpId(emp);
        empRepository.save(emp);
        return "Data has been stored, and generated emp id for new user is " + emp.getEmpId();
    }
}
