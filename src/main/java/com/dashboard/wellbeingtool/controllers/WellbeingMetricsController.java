package com.dashboard.wellbeingtool.controllers;

import com.dashboard.wellbeingtool.dtos.WellbeingMetricsDTO;
import com.dashboard.wellbeingtool.service.WellbeingMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wellbeing")
public class WellbeingMetricsController {

    @Autowired
    private WellbeingMetricsService wellbeingMetricsService;

    @PostMapping
    public ResponseEntity<WellbeingMetricsDTO> submitWellbeingMetrics(@RequestBody WellbeingMetricsDTO wellbeingMetricsDTO) {
        return ResponseEntity.ok(wellbeingMetricsService.saveWellbeingMetrics(wellbeingMetricsDTO));
    }
}
