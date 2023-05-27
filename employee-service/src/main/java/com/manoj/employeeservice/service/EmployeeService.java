package com.manoj.employeeservice.service;

import com.manoj.employeeservice.dto.ApiResponseDto;
import com.manoj.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    ApiResponseDto getEmployeeById(Long id);
}
