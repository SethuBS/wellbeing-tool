package com.dashboard.wellbeingtool.repository;

import com.dashboard.wellbeingtool.entities.WellbeingMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WellbeingMetricsRepository extends JpaRepository<WellbeingMetrics, Long> {
}
