package com.campusdiaries.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campusdiaries.entity.Post;
import com.campusdiaries.entity.TempUser;
import com.campusdiaries.entity.User;
import com.campusdiaries.service.TempUserService;
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.FileUploadUtil;
import com.campusdiaries.util.Helper;

@Controller
@RequestMapping(value = "tempUser")
public class TempUserController {
	private TempUserService tempUserService;
	private UserService userService;

	public TempUserController(TempUserService tempUserService, UserService userService) {
		this.tempUserService = tempUserService;
		this.userService = userService;
	}

	@GetMapping(value = "/index")
	public String tempUsers(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		List<TempUser> tempUsers = tempUserService.getAllTempUser();
		model.addAttribute("listTempUsers", tempUsers);
		model.addAttribute("keyword", keyword);
		return "admin/list/tempUsers_list";
	}

	@GetMapping(value = "/create")
	public String formTempUsers(Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		model.addAttribute("tempUser", new TempUser());
		List<User> users = userService.getAllUser();
		model.addAttribute("listUsers", users);

		return "admin/entry/tempUser_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteTempUser(@PathVariable(value = "id") Integer id, String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		tempUserService.removeTempUser(id);
		return "redirect:/tempUser/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updateTempUser(@PathVariable(value = "id") Integer id, Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		TempUser tempUser = tempUserService.loadTempUserById(id);
		model.addAttribute("tempUser", tempUser);
		List<User> users = userService.getAllUserByRole("Tamp_Student");
		model.addAttribute("listUsers", users);

		return "admin/edit/tempUser_edit";
	}

	@PostMapping(value = "/save")
	public String save(TempUser tempUser,@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2 ) throws IOException {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		String fileName = StringUtils.cleanPath(file1.getOriginalFilename());
	    String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
	    
	    if(fileName.length()>3) {
		tempUser.setCollegeIdPhoto(fileName);	
		
	    String uploadDir = "assets1/images/temps";
	    FileUploadUtil.saveFile(uploadDir, fileName,file1);
	    }
	    
	    if(fileName2.length()>3) {
		
		tempUser.setPhoto(fileName2);
		
	    String uploadDir = "assets1/images/temps";
	    FileUploadUtil.saveFile(uploadDir, fileName2,file2);
	    }
		tempUserService.createOrUpdateTempUser(tempUser);
	    
	
		return "redirect:/tempUser/index";
	}

}
