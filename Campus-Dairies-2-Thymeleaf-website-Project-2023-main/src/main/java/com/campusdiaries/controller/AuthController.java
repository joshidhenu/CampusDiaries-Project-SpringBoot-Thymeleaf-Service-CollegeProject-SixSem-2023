package com.campusdiaries.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.campusdiaries.entity.User;
import com.campusdiaries.service.EventRegistrationService;
import com.campusdiaries.service.EventService;
import com.campusdiaries.service.StaffMasterService;
import com.campusdiaries.service.StudentMasterService;
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.Helper;

@Controller

public class AuthController {
	UserService userService;
	
	StudentMasterService  studentMasterService;
	StaffMasterService staffMasterService;
	EventRegistrationService eventRegistrationService;
	EventService eventService;
	
	
	

	public AuthController(UserService userService, StudentMasterService studentMasterService,
			StaffMasterService staffMasterService, EventRegistrationService eventRegistrationService,
			EventService eventService) {
		super();
		this.userService = userService;
		this.studentMasterService = studentMasterService;
		this.staffMasterService = staffMasterService;
		this.eventRegistrationService = eventRegistrationService;
		this.eventService = eventService;
	}
	

	@GetMapping("/dashboard")
	public String getDashboard(Model m,HttpSession session ) {
		if(!Helper.checkAdminRole()&&!Helper.checkStaffRole()&&!Helper.checkStudentRole()&&!Helper.checkTempUserRole()) 
		{ return "redirect:/login";}
		
		
		int s_count =  studentMasterService.getAllStudentMaster().size();
		int t_count =  staffMasterService.getAllStaffMaster().size();
		int r_count =  eventRegistrationService.getAllEventRegistration().size();
		int e_count =  eventService.getAllEvent().size();
		m.addAttribute("student_count",s_count);
		m.addAttribute("staff_count",t_count);
		m.addAttribute("registration_count",r_count);
		m.addAttribute("event_count",e_count);
		System.out.println("xxxxx");
		System.out.println(session.getAttribute("urole"));
		System.out.println("xxxxx");
		
		
		return "admin/dashboard";
		
		
	}


	// \\//\\//\\//\\//\\//\\//\\//\\

	@GetMapping("/profile")
	public String profile(Model m) {
		
		if(!Helper.checkAdminRole()) {
			return "redirect:/logout";
		}
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		int uid = 0;
		if(session.getAttribute("uid") != null) {
			uid = (int)session.getAttribute("uid");
		} 
		User user = userService.loadUserById(uid);
		m.addAttribute("user",user);
		
		
		return "/admin/profile";
	}

	@GetMapping("/edit-profile")
	public String editProfile(Model m) {
		if(!Helper.checkAdminRole()) {
			return "redirect:/logout";
		}
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		int uid = 0;
		if(session.getAttribute("uid") != null) {
			uid = (int)session.getAttribute("uid");
		} 
		User user = userService.loadUserById(uid);
		m.addAttribute("user",user);
		
		return "/admin/profile-edit";
	}
	@PostMapping("/edit-profile")
	public String updateProfile(User user) {
		if(!Helper.checkAdminRole()) {
			return "redirect:/logout";
		}
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		int uid = 0;
		if(session.getAttribute("uid") != null) {
			uid = (int)session.getAttribute("uid");
			User user2 = userService.loadUserById(uid);
			user2.setName(user.getName());
			user2.setEmail(user.getEmail());
			user2.setPhone(user.getPhone());
			userService.createOrUpdateUser(user2);
		} 
		
		session.setAttribute("msg", "Profile Updated successfully..");
		
		return "/admin";
	}

	@GetMapping("/change-password")
	public String changepassword(@RequestParam("password")String password) {
		if(!Helper.checkAdminRole()) {
			return "redirect:/logout";
		}
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		int uid = 0;
		if(session.getAttribute("uid") != null) {
			uid = (int)session.getAttribute("uid");
			User user2 = userService.loadUserById(uid);
			user2.setPassword(password);
			userService.createOrUpdateUser(user2);
		} 
		
		session.setAttribute("msg", "Password change successfully..");
		
		return "/admin";
	}

	
	

}
