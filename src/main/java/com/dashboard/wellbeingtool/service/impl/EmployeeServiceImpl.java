package com.dashboard.wellbeingtool.service.impl;

import com.dashboard.wellbeingtool.dtos.EmployeeDTO;
import com.dashboard.wellbeingtool.exceptions.EmployeeFoundException;
import com.dashboard.wellbeingtool.maps.Mapper;
import com.dashboard.wellbeingtool.repository.EmployeeRepository;
import com.dashboard.wellbeingtool.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) throws EmployeeFoundException {
        var existingEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());

        if (existingEmployee != null)
            throw new EmployeeFoundException("Employee with given email: " + employeeDTO.getEmail() + "already exists in the system");

        var newEmployee = Mapper.entityMap(employeeDTO);

        var savedEmployee = employeeRepository.save(newEmployee);

        return Mapper.dtoMap(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(Mapper::dtoMap)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) throws EmployeeFoundException {
        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeFoundException("Employee with given id: " + employeeId + " does not exist"));
        return Mapper.dtoMap(employee);
    }
}
