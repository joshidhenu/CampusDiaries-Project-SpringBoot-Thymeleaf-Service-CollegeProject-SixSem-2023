package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.ReplyComment;

public interface ReplyCommentDAO extends JpaRepository<ReplyComment, Integer> { 

} 
