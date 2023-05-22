package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.Post;

public interface PostDAO extends JpaRepository<Post, Integer> { 

} 
