package com.campusdiaries.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campusdiaries.entity.StudentMaster;
import com.campusdiaries.entity.User;
import com.campusdiaries.service.StudentMasterService;
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.FileUploadUtil;
import com.campusdiaries.util.Helper;

@Controller
@RequestMapping(value = "studentMaster")
public class StudentMasterController {
	private StudentMasterService studentMasterService;
	private UserService userService;

	public StudentMasterController(StudentMasterService studentMasterService, UserService userService) {
		this.studentMasterService = studentMasterService;
		this.userService = userService;
	}

	@GetMapping(value = "/index")
	public String studentMasters(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		List<StudentMaster> studentMasters = studentMasterService.getAllStudentMaster();
		model.addAttribute("listStudentMasters", studentMasters);
		model.addAttribute("keyword", keyword);
		return "admin/list/studentMasters_list";
	}

	@GetMapping(value = "/create")
	public String formStudentMasters(Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		model.addAttribute("studentMaster", new StudentMaster());
		
		List<User> users = userService.getAllUserByRole("Student");
		model.addAttribute("listUsers", users);

		return "admin/entry/studentMaster_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteStudentMaster(@PathVariable(value = "id") Integer id, String keyword,HttpSession session) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		studentMasterService.removeStudentMaster(id);
		session.setAttribute("msg", "deleted");
		return "redirect:/studentMaster/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateStudentMaster(@PathVariable(value = "id") Integer id, Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		StudentMaster studentMaster = studentMasterService.loadStudentMasterById(id);
		model.addAttribute("studentMaster", studentMaster);
		List<User> users = userService.getAllUserByRole("Student");
		model.addAttribute("listUsers", users);

		return "admin/edit/studentMaster_edit";
	}

	@PostMapping(value = "/save")
	public String save(StudentMaster studentMaster, @RequestParam("file") MultipartFile file,HttpSession session) throws IOException {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		StudentMaster s = null;
		String msg="";
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	   
	    if(fileName.length()>3) {
	    studentMaster.setPhoto(fileName);
	    s = studentMasterService.createOrUpdateStudentMaster(studentMaster);
	    String uploadDir = "assets1/images/students";
	    FileUploadUtil.saveFile(uploadDir, fileName,file);
	    }else {
		 s =studentMasterService.createOrUpdateStudentMaster(studentMaster);
	    }
	    
	    
		if(s !=null) {
			session.setAttribute("msg", msg);
		}else {
			session.setAttribute("error", "error");
		}
	    
		return "redirect:/studentMaster/index";
	}

}
