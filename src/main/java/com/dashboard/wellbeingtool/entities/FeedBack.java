package com.dashboard.wellbeingtool.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "feedback_text")
    private String feedbackText;
    @Column(name = "sentiment_score")
    private double sentimentScore;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
