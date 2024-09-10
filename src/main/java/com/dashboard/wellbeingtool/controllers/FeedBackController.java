package com.dashboard.wellbeingtool.controllers;

import com.dashboard.wellbeingtool.dtos.FeedBackDTO;
import com.dashboard.wellbeingtool.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedBackDTO> submitFeedback(@RequestBody FeedBackDTO feedback) {
        return ResponseEntity.ok(feedbackService.saveFeedBack(feedback));
    }
}
