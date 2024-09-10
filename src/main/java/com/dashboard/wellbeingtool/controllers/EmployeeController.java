package com.dashboard.wellbeingtool.controllers;

import com.dashboard.wellbeingtool.dtos.EmployeeDTO;
import com.dashboard.wellbeingtool.exceptions.EmployeeFoundException;
import com.dashboard.wellbeingtool.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) throws EmployeeFoundException {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) throws EmployeeFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
