package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.CommentPostDAO; 
import com.campusdiaries.entity.CommentPost; 
import com.campusdiaries.service.CommentPostService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentPostServiceImpl implements CommentPostService { 

@Autowired
 private CommentPostDAO commentPostDao;
 
 @Override 
    public List<CommentPost> getAllCommentPost() { 
        return commentPostDao.findAll(); 
    } 

@Override 
  public CommentPost loadCommentPostById(Integer id) {
 return commentPostDao.findById(id).orElseThrow(() -> new EntityNotFoundException("CommentPost with ID " + id + " Not Found"));
 }

@Override 
    public CommentPost createOrUpdateCommentPost(CommentPost commentPost) {
return commentPostDao.save(commentPost);
   }

  @Override
 	    public void removeCommentPost(Integer id) {
 	        commentPostDao.deleteById(id);
 	    }

}
