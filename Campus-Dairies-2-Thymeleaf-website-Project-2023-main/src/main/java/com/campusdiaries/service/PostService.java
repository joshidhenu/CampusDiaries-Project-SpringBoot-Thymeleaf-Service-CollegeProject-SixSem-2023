package com.campusdiaries.service;

import com.campusdiaries.entity.Post;
import java.util.List;

public interface PostService { 

  List<Post> getAllPost();

Post loadPostById(Integer id );

Post createOrUpdatePost(Post post);

void removePost(Integer id);

} 
