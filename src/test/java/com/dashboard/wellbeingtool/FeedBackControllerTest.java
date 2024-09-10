package com.dashboard.wellbeingtool;

import com.dashboard.wellbeingtool.controllers.FeedBackController;
import com.dashboard.wellbeingtool.dtos.FeedBackDTO;
import com.dashboard.wellbeingtool.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FeedBackControllerTest {

    @Mock
    private FeedbackService feedbackService;

    @InjectMocks
    private FeedBackController feedBackController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitFeedback() {
        // Arrange
        FeedBackDTO feedbackDTO = FeedBackDTO.builder()
                .id(1L)
                .employeeDTO(null) // Adjust as necessary
                .feedbackText("Great job!")
                .sentimentScore(0.9)
                .createdDate(LocalDateTime.now())
                .build();

        // Mock the service call
        when(feedbackService.saveFeedBack(feedbackDTO)).thenReturn(feedbackDTO);

        // Act
        ResponseEntity<FeedBackDTO> response = feedBackController.submitFeedback(feedbackDTO);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(feedbackDTO, response.getBody());
    }
}
