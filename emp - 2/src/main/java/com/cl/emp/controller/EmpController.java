package com.cl.emp.controller;

import com.cl.emp.constants.MessageConstants;
import com.cl.emp.dto.EmpDto;
import com.cl.emp.dto.EmpRequestDTO;
import com.cl.emp.dto.ResponseDto;
import com.cl.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{empId}")
    public ResponseDto getEmployeeDetails(@PathVariable Long empId){
        EmpDto empById = employeeService.getEmpById(empId);
        if(empById!=null){
            return ResponseDto.ok(empById, MessageConstants.DATA_RETRIEVED_SUCCESS);
        }else{
            return ResponseDto.not_found(MessageConstants.NO_DATA_FOUND);
        }
    }

    @PostMapping("/saveEmpDetails")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto saveEmpDetails(@RequestBody EmpRequestDTO empRequestDTO){
        String result = employeeService.saveEmp(empRequestDTO);
        if(!result.isEmpty()){
            return ResponseDto.create(result,MessageConstants.DATA_RETRIEVED_SUCCESS);
        }
        else{
            return ResponseDto.bad_request(MessageConstants.DATA_SAVED_ERROR);
        }

    }

}
