package com.manoj.employeeservice.service;

import com.manoj.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/departments/get/{department-code}")
    DepartmentDto findByDepartmentCode(@PathVariable("department-code") String departmentCode);
}
