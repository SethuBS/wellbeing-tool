package com.dashboard.wellbeingtool.maps;

import com.dashboard.wellbeingtool.dtos.EmployeeDTO;
import com.dashboard.wellbeingtool.entities.Employee;

public class Mapper {

    public static EmployeeDTO dtoMap(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getRole()
        );
    }

    public static Employee entityMap(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartment(),
                employeeDTO.getRole()
        );
    }
}
