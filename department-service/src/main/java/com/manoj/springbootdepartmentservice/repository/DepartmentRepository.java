package com.manoj.springbootdepartmentservice.repository;

import com.manoj.springbootdepartmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCode(String departmentCode);
}
