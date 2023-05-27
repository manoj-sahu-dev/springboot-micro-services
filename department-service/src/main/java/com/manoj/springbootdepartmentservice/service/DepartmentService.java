package com.manoj.springbootdepartmentservice.service;

import com.manoj.springbootdepartmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto findByDepartmentCode(String departmentCode);
}
