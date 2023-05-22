package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.ReplyCommentDAO; 
import com.campusdiaries.entity.ReplyComment; 
import com.campusdiaries.service.ReplyCommentService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReplyCommentServiceImpl implements ReplyCommentService { 

@Autowired
 private ReplyCommentDAO replyCommentDao;
 
 @Override 
    public List<ReplyComment> getAllReplyComment() { 
        return replyCommentDao.findAll(); 
    } 

@Override 
  public ReplyComment loadReplyCommentById(Integer id) {
 return replyCommentDao.findById(id).orElseThrow(() -> new EntityNotFoundException("ReplyComment with ID " + id + " Not Found"));
 }

@Override 
    public ReplyComment createOrUpdateReplyComment(ReplyComment replyComment) {
return replyCommentDao.save(replyComment);
   }

  @Override
 	    public void removeReplyComment(Integer id) {
 	        replyCommentDao.deleteById(id);
 	    }

}
