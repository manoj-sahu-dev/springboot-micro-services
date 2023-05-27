package com.manoj.springbootdepartmentservice.controller;

import com.manoj.springbootdepartmentservice.dto.DepartmentDto;
import com.manoj.springbootdepartmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;


    @PostMapping("save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/get/{department-code}")
    public ResponseEntity<DepartmentDto> findByDepartmentCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.findByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
