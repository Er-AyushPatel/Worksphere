package com.worksphere.worksphere.repository;

import com.worksphere.worksphere.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
}