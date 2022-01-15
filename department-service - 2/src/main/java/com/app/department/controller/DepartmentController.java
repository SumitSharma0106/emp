package com.app.department.controller;

import com.app.department.entity.Department;
import com.app.department.repository.DepartmentRepository;
import com.app.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartment/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }
}
