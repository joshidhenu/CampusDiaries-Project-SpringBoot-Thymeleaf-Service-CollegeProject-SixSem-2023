package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.Feedback;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> { 

} 
