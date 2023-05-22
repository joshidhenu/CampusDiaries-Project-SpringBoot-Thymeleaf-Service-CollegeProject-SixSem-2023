package com.campusdiaries.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.Event;

public interface EventDAO extends JpaRepository<Event, Integer> { 

	
	List<Event> findByLastDateLessThan( Date date);
	
	List<Event> findByStartDateGreaterThan(Date date);
	
	
} 
