package com.dashboard.wellbeingtool.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WellbeingMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "employee_wellbeing_metrics",
            joinColumns = @JoinColumn(name = "wellbeing_metrics_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;
    private int stressLevel;
    private int sleepHours;
    private int physicalActivity;
    private LocalDateTime createdAt = LocalDateTime.now();

}
