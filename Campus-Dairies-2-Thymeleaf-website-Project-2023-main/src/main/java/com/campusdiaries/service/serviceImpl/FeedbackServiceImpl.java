package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.FeedbackDAO; 
import com.campusdiaries.entity.Feedback; 
import com.campusdiaries.service.FeedbackService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService { 

@Autowired
 private FeedbackDAO feedbackDao;
 
 @Override 
    public List<Feedback> getAllFeedback() { 
        return feedbackDao.findAll(); 
    } 

@Override 
  public Feedback loadFeedbackById(Integer id) {
 return feedbackDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Feedback with ID " + id + " Not Found"));
 }

@Override 
    public Feedback createOrUpdateFeedback(Feedback feedback) {
return feedbackDao.save(feedback);
   }

  @Override
 	    public void removeFeedback(Integer id) {
 	        feedbackDao.deleteById(id);
 	    }

}
