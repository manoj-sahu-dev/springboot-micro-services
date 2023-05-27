package com.manoj.employeeservice.controller;

import com.manoj.employeeservice.dto.ApiResponseDto;
import com.manoj.employeeservice.dto.EmployeeDto;
import com.manoj.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // build save employee rest api

    @PostMapping("create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDto>>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable(name = "id") Long id) {
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
