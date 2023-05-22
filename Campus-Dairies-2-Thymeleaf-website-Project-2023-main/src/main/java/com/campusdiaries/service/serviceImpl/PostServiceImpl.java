package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.PostDAO; 
import com.campusdiaries.entity.Post; 
import com.campusdiaries.service.PostService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostServiceImpl implements PostService { 

@Autowired
 private PostDAO postDao;
 
 @Override 
    public List<Post> getAllPost() { 
        return postDao.findAll(); 
    } 

@Override 
  public Post loadPostById(Integer id) {
 return postDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with ID " + id + " Not Found"));
 }

@Override 
    public Post createOrUpdatePost(Post post) {
return postDao.save(post);
   }

  @Override
 	    public void removePost(Integer id) {
 	        postDao.deleteById(id);
 	    }

}
