package com.campusdiaries.service;

import com.campusdiaries.entity.CommentPost;
import java.util.List;

public interface CommentPostService { 

  List<CommentPost> getAllCommentPost();

CommentPost loadCommentPostById(Integer id );

CommentPost createOrUpdateCommentPost(CommentPost commentPost);

void removeCommentPost(Integer id);

} 
