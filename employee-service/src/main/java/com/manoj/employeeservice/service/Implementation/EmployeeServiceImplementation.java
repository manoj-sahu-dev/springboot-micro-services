package com.manoj.employeeservice.service.Implementation;

import com.manoj.employeeservice.dto.ApiResponseDto;
import com.manoj.employeeservice.dto.DepartmentDto;
import com.manoj.employeeservice.dto.EmployeeDto;
import com.manoj.employeeservice.entity.Employee;
import com.manoj.employeeservice.exception.EmailAlreadyExistException;
import com.manoj.employeeservice.exception.ResourceNotFoundException;
import com.manoj.employeeservice.repository.EmployeeRepository;
import com.manoj.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        var emp = employeeRepository.findByEmail(employeeDto.getEmail());
        if (emp.isPresent()) {
            throw new EmailAlreadyExistException("email " + employeeDto.getEmail() + " already registered!");
        }

        Employee savedEmployee = employeeRepository.save(modelMapper.map(employeeDto, Employee.class));

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        var dto = employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("employee with id: " + id + "not found!")
        );
        String departmentCode = employee.getDepartmentCode();
        String url = "http://localhost:8080/api/departments/get/" + departmentCode;
        System.out.println(url);
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity(url, DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(modelMapper.map(employee, EmployeeDto.class));
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
