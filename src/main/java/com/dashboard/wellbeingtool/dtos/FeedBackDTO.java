package com.dashboard.wellbeingtool.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDTO {
    private Long id;

    @NotNull(message = "Employee information cannot be null")
    @Valid // Ensures that the nested EmployeeDTO is also validated
    private EmployeeDTO employeeDTO;

    @NotEmpty(message = "Feedback text cannot be empty")
    private String feedbackText;

    @Positive(message = "Sentiment score must be a positive number")
    private double sentimentScore;

    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime createdDate = LocalDateTime.now();
}
