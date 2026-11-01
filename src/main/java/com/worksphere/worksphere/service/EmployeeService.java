package com.worksphere.worksphere.service;

import com.worksphere.worksphere.dto.EmployeeRequestDTO;
import com.worksphere.worksphere.dto.EmployeeResponseDTO;
import com.worksphere.worksphere.model.Department;
import com.worksphere.worksphere.model.Employee;
import com.worksphere.worksphere.repository.DepartmentRepository;
import com.worksphere.worksphere.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {

        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request) {

        Department department =
                departmentRepository
                        .findById(request.getDepartmentId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Department not found"
                                )
                        );

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(department);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return new EmployeeResponseDTO(
                savedEmployee.getId(),
                savedEmployee.getName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartment().getName()
        );
    }

    // READ - ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ - BY ID
    public Employee getEmployeeById(int id) {
        return employeeRepository
                .findById(id)
                .orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(
            int id,
            Employee updatedEmployee) {

        Employee existingEmployee =
                employeeRepository
                        .findById(id)
                        .orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setDepartment(
                updatedEmployee.getDepartment()
        );

        return employeeRepository.save(existingEmployee);
    }

    // DELETE
    public boolean deleteEmployee(int id) {

        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);
        return true;
    }
}