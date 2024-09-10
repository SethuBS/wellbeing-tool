package com.dashboard.wellbeingtool.service.impl;

import com.dashboard.wellbeingtool.dtos.FeedBackDTO;
import com.dashboard.wellbeingtool.maps.Mapper;
import com.dashboard.wellbeingtool.repository.FeedbackRepository;
import com.dashboard.wellbeingtool.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedBackDTO saveFeedBack(FeedBackDTO newFeedBackDTO) {
        var feedBackEntity = Mapper.entityMap(newFeedBackDTO);
        var savedFeedBack = feedbackRepository.save(feedBackEntity);
        return Mapper.dtoMap(savedFeedBack);
    }
}
