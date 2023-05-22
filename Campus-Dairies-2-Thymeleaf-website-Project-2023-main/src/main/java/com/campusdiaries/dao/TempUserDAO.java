package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.TempUser;

public interface TempUserDAO extends JpaRepository<TempUser, Integer> { 

} 
