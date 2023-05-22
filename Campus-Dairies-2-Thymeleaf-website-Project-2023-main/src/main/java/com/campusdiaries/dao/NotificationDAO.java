package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.Notification;

public interface NotificationDAO extends JpaRepository<Notification, Integer> { 

} 
