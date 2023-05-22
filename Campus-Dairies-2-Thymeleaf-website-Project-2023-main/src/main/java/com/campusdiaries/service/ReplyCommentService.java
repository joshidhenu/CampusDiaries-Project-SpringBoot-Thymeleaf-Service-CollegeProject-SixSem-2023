package com.campusdiaries.service;

import com.campusdiaries.entity.ReplyComment;
import java.util.List;

public interface ReplyCommentService { 

  List<ReplyComment> getAllReplyComment();

ReplyComment loadReplyCommentById(Integer id );

ReplyComment createOrUpdateReplyComment(ReplyComment replyComment);

void removeReplyComment(Integer id);

} 
