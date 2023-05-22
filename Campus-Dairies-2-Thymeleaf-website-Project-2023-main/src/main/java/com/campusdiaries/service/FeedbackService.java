package com.campusdiaries.service;

import com.campusdiaries.entity.Feedback;
import java.util.List;

public interface FeedbackService { 

  List<Feedback> getAllFeedback();

Feedback loadFeedbackById(Integer id );

Feedback createOrUpdateFeedback(Feedback feedback);

void removeFeedback(Integer id);

} 
