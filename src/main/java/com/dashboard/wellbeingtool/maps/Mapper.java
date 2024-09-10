package com.dashboard.wellbeingtool.maps;

import com.dashboard.wellbeingtool.dtos.EmployeeDTO;
import com.dashboard.wellbeingtool.dtos.FeedBackDTO;
import com.dashboard.wellbeingtool.dtos.WellbeingMetricsDTO;
import com.dashboard.wellbeingtool.entities.Employee;
import com.dashboard.wellbeingtool.entities.FeedBack;
import com.dashboard.wellbeingtool.entities.WellbeingMetrics;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static EmployeeDTO dtoMap(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .role(employee.getRole())
                .build();
    }

    public static Employee entityMap(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .email(employeeDTO.getEmail())
                .department(employeeDTO.getDepartment())
                .role(employeeDTO.getRole())
                .build();
    }

    public static FeedBack entityMap(FeedBackDTO feedBackDTO) {
        if (feedBackDTO == null) {
            return null;
        }
        return FeedBack.builder()
                .id(feedBackDTO.getId())
                .employee(entityMap(feedBackDTO.getEmployeeDTO())) // Add conversion method
                .feedbackText(feedBackDTO.getFeedbackText())
                .sentimentScore(feedBackDTO.getSentimentScore())
                .createdAt(feedBackDTO.getCreatedDate())
                .build();
    }

    public static FeedBackDTO dtoMap(FeedBack feedBack) {
        if (feedBack == null) {
            return null;
        }
        return FeedBackDTO.builder()
                .id(feedBack.getId())
                .employeeDTO(dtoMap(feedBack.getEmployee())) // Add conversion method
                .feedbackText(feedBack.getFeedbackText())
                .sentimentScore(feedBack.getSentimentScore())
                .createdDate(feedBack.getCreatedAt())
                .build();
    }

    public static WellbeingMetrics toEntity(WellbeingMetricsDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Employee> employees = dto.getEmployeeDTOs().stream()
                .map(Mapper::entityMap)
                .collect(Collectors.toList());

        return WellbeingMetrics.builder()
                .id(dto.getId())
                .employees(employees)
                .stressLevel(dto.getStressLevel())
                .sleepHours(dto.getSleepHours())
                .physicalActivity(dto.getPhysicalActivity())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public static WellbeingMetricsDTO toDTO(WellbeingMetrics entity) {
        if (entity == null) {
            return null;
        }

        List<EmployeeDTO> employeeDTOs = entity.getEmployees().stream()
                .map(Mapper::dtoMap)
                .collect(Collectors.toList());

        return WellbeingMetricsDTO.builder()
                .id(entity.getId())
                .employeeDTOs(employeeDTOs)
                .stressLevel(entity.getStressLevel())
                .sleepHours(entity.getSleepHours())
                .physicalActivity(entity.getPhysicalActivity())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
