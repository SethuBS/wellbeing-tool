package com.dashboard.wellbeingtool.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String role;
}
