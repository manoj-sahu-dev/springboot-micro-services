package com.manoj.springbootdepartmentservice.repository;

import com.manoj.springbootdepartmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findDepartmentByDepartmentCode(String departmentCode);
}
