package com.dashboard.wellbeingtool.repository;

import com.dashboard.wellbeingtool.entities.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {
}
