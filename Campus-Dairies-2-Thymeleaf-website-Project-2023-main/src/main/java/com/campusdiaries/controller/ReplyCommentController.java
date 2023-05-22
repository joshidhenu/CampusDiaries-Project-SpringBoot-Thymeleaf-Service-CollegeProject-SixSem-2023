package com.campusdiaries.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campusdiaries.entity.CommentPost;
import com.campusdiaries.entity.ReplyComment;
import com.campusdiaries.entity.User;
import com.campusdiaries.service.CommentPostService;
import com.campusdiaries.service.ReplyCommentService;
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.Helper;

@Controller
@RequestMapping(value = "replyComment")
public class ReplyCommentController {
	private ReplyCommentService replyCommentService;
	private CommentPostService commentPostService;
	private UserService userService;

	public ReplyCommentController(ReplyCommentService replyCommentService, CommentPostService commentPostService,
			UserService userService) {
		this.replyCommentService = replyCommentService;
		this.commentPostService = commentPostService;
		this.userService = userService;
	}

	@GetMapping(value = "/index")
	public String replyComments(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		List<ReplyComment> replyComments = replyCommentService.getAllReplyComment();
		model.addAttribute("listReplyComments", replyComments);
		model.addAttribute("keyword", keyword);
		return "admin/list/replyComments_list";
	}

	@GetMapping(value = "/create")
	public String formReplyComments(Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		model.addAttribute("replyComment", new ReplyComment());
		List<CommentPost> commentPosts = commentPostService.getAllCommentPost();
		model.addAttribute("listCommentPosts", commentPosts);

		List<User> users = userService.getAllUser();
		model.addAttribute("listUsers", users);

		return "admin/entry/replyComment_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteReplyComment(@PathVariable(value = "id") Integer id, String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		replyCommentService.removeReplyComment(id);
		return "redirect:/replyComment/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateReplyComment(@PathVariable(value = "id") Integer id, Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		ReplyComment replyComment = replyCommentService.loadReplyCommentById(id);
		model.addAttribute("replyComment", replyComment);
		List<CommentPost> commentPosts = commentPostService.getAllCommentPost();
		model.addAttribute("listCommentPosts", commentPosts);

		List<User> users = userService.getAllUser();
		model.addAttribute("listUsers", users);

		return "admin/edit/replyComment_edit";
	}

	@PostMapping(value = "/save")
	public String save(ReplyComment replyComment) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		replyCommentService.createOrUpdateReplyComment(replyComment);
		return "redirect:/replyComment/index";
	}

}
