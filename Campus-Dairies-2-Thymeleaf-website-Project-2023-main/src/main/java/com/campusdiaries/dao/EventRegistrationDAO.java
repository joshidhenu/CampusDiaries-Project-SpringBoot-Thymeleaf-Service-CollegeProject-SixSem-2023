package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.EventRegistration;

public interface EventRegistrationDAO extends JpaRepository<EventRegistration, Integer> { 

} 
