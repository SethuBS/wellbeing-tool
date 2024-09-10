package com.dashboard.wellbeingtool.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WellbeingMetricsDTO {
    private Long id;

    @NotNull(message = "Employee list cannot be null")
    private List<EmployeeDTO> employeeDTOs;

    @NotNull(message = "Stress level cannot be null")
    private Integer stressLevel;

    @NotNull(message = "Sleep hours cannot be null")
    private Integer sleepHours;

    @NotNull(message = "Physical activity cannot be null")
    private Integer physicalActivity;

    private LocalDateTime createdAt = LocalDateTime.now();
}
