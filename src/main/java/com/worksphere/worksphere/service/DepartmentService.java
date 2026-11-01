package com.worksphere.worksphere.service;

import com.worksphere.worksphere.model.Department;
import com.worksphere.worksphere.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // READ ALL
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // READ BY ID
    public Department getDepartmentById(int id) {
        return departmentRepository
                .findById(id)
                .orElse(null);
    }

    // DELETE
    public boolean deleteDepartment(int id) {

        if (!departmentRepository.existsById(id)) {
            return false;
        }

        departmentRepository.deleteById(id);
        return true;
    }
}