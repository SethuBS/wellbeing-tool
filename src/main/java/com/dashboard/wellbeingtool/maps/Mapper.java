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

    public static WellbeingMetrics toEntity(WellbeingMetricsDTO wellbeingMetricsDTO) {
        if (wellbeingMetricsDTO == null) {
            return null;
        }

        List<Employee> employees = wellbeingMetricsDTO.getEmployeeDTOs().stream()
                .map(Mapper::entityMap)
                .collect(Collectors.toList());

        return WellbeingMetrics.builder()
                .id(wellbeingMetricsDTO.getId())
                .employees(employees)
                .stressLevel(wellbeingMetricsDTO.getStressLevel())
                .sleepHours(wellbeingMetricsDTO.getSleepHours())
                .physicalActivity(wellbeingMetricsDTO.getPhysicalActivity())
                .createdAt(wellbeingMetricsDTO.getCreatedAt())
                .build();
    }

    public static WellbeingMetricsDTO dtoMap(WellbeingMetrics wellbeingMetrics) {
        if (wellbeingMetrics == null) {
            return null;
        }

        List<EmployeeDTO> employeeDTOs = wellbeingMetrics.getEmployees().stream()
                .map(Mapper::dtoMap)
                .collect(Collectors.toList());

        return WellbeingMetricsDTO.builder()
                .id(wellbeingMetrics.getId())
                .employeeDTOs(employeeDTOs)
                .stressLevel(wellbeingMetrics.getStressLevel())
                .sleepHours(wellbeingMetrics.getSleepHours())
                .physicalActivity(wellbeingMetrics.getPhysicalActivity())
                .createdAt(wellbeingMetrics.getCreatedAt())
                .build();
    }
}
