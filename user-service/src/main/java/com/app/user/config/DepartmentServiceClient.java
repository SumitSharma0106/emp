package com.app.user.config;

import com.app.user.VO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentServiceClient {

    @GetMapping("/services/department/getDepartment/{deptId}")
    public Department getDepartmentID(@PathVariable Long deptId);
}
