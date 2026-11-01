package com.worksphere.worksphere.repository;

import com.worksphere.worksphere.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Integer> {
}