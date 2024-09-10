package com.dashboard.wellbeingtool;

import com.dashboard.wellbeingtool.controllers.WellbeingMetricsController;
import com.dashboard.wellbeingtool.dtos.WellbeingMetricsDTO;
import com.dashboard.wellbeingtool.service.WellbeingMetricsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WellbeingMetricsControllerTest {

    @Mock
    private WellbeingMetricsService wellbeingMetricsService;

    @InjectMocks
    private WellbeingMetricsController wellbeingMetricsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitWellbeingMetrics() {
        // Arrange
        WellbeingMetricsDTO wellbeingMetricsDTO = WellbeingMetricsDTO.builder()
                .id(1L)
                .employeeDTOs(Collections.emptyList()) // Replace with actual data if needed
                .stressLevel(5)
                .sleepHours(8)
                .physicalActivity(3)
                .createdAt(LocalDateTime.now())
                .build();

        // Mock the service call
        when(wellbeingMetricsService.saveWellbeingMetrics(wellbeingMetricsDTO)).thenReturn(wellbeingMetricsDTO);

        // Act
        ResponseEntity<WellbeingMetricsDTO> response = wellbeingMetricsController.submitWellbeingMetrics(wellbeingMetricsDTO);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(wellbeingMetricsDTO, response.getBody());
    }
}
