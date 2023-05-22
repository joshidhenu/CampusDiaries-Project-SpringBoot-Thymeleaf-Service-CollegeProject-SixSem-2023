package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.CommentPost;

public interface CommentPostDAO extends JpaRepository<CommentPost, Integer> { 

} 
