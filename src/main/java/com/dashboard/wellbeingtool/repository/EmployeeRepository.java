package com.dashboard.wellbeingtool.repository;

import com.dashboard.wellbeingtool.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
