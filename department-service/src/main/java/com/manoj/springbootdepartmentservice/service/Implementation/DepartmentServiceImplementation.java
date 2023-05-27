package com.manoj.springbootdepartmentservice.service.Implementation;

import com.manoj.springbootdepartmentservice.dto.DepartmentDto;
import com.manoj.springbootdepartmentservice.entity.Department;
import com.manoj.springbootdepartmentservice.repository.DepartmentRepository;
import com.manoj.springbootdepartmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImplementation implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department DTO to entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto findByDepartmentCode(String departmentCode) {
        Optional<Department> departmentOption = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        Department department = departmentOption.get();
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }


}
