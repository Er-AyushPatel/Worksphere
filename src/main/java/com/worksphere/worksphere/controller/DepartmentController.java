package com.worksphere.worksphere.controller;

import com.worksphere.worksphere.model.Department;
import com.worksphere.worksphere.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(
            @RequestBody Department department) {

        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(
            @PathVariable int id) {

        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable int id) {

        boolean deleted = departmentService.deleteDepartment(id);

        if (!deleted) {
            return "Department not found";
        }

        return "Department deleted successfully";
    }
}