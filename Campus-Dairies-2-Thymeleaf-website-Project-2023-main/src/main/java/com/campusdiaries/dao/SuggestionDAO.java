package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.Suggestion;

public interface SuggestionDAO extends JpaRepository<Suggestion, Integer> { 

} 
