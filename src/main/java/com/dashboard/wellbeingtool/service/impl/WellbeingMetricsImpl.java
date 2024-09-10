package com.dashboard.wellbeingtool.service.impl;

import com.dashboard.wellbeingtool.dtos.WellbeingMetricsDTO;
import com.dashboard.wellbeingtool.maps.Mapper;
import com.dashboard.wellbeingtool.repository.WellbeingMetricsRepository;
import com.dashboard.wellbeingtool.service.WellbeingMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WellbeingMetricsImpl implements WellbeingMetricsService {

    @Autowired
    private WellbeingMetricsRepository wellbeingMetricsRepository;

    @Override
    public WellbeingMetricsDTO saveWellbeingMetrics(WellbeingMetricsDTO newWellbeingMetricsDTO) {
        var wellbeingMetrics = Mapper.toEntity(newWellbeingMetricsDTO);
        var savedWellbeingMetrics = wellbeingMetricsRepository.save(wellbeingMetrics);
        return Mapper.dtoMap(savedWellbeingMetrics);
    }
}
