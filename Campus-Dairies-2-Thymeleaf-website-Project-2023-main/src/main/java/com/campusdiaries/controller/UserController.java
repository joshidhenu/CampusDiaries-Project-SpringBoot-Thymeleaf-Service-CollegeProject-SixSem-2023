package com.campusdiaries.controller;

import com.campusdiaries.entity.User; 
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.Helper;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import java.util.List; 
@Controller 
@RequestMapping(value = "user") 
public class UserController { 
 private UserService userService; 
    public UserController(UserService userService) { 
        this.userService = userService; 
    }
 
    @GetMapping(value = "/index") 
    public String users(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) { 
    	if(!Helper.checkSession()) { return "redirect:/login";}
		
    	List<User> users = userService.getAllUser(); 
        model.addAttribute("listUsers", users); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/users_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formUsers(Model model) { 
	  if(!Helper.checkSession()) { return "redirect:/login";}
		
	  model.addAttribute("user", new User()); 
        return "admin/entry/user_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteUser(@PathVariable(value = "id") Integer id, String keyword) { 
    	if(!Helper.checkSession()) { return "redirect:/login";}
		
    	userService.removeUser(id); 
        return "redirect:/user/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateUser(@PathVariable(value = "id") Integer id, Model model) { 
    	if(!Helper.checkSession()) { return "redirect:/login";}
		
    	User user = userService.loadUserById(id); 
        model.addAttribute("user", user); 
        return "admin/edit/user_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(User user) { 
    	if(!Helper.checkSession()) { return "redirect:/login";}
        
       
          User savedUser =  userService.createOrUpdateUser(user); 
          int id = savedUser.getId();
//        if(user.getRole().equals("student") ) {
//            model.addAttribute("studentMaster", new StudentMaster());
//		User users = userService.loadUserById(id);
//		model.addAttribute("listUsers", users);
//
//		return "admin/entry/studentMaster_entry";
//        }else if(user.getRole().equals("staff")) {
//            return "redirect:@{/staffMaster/create/{id}(id=${user.id})}";
//        }else if(user.getRole().equals("temp_user")) {
//            return "redirect:@{/tempUser/create/{id}(id=${user.id})}";
//        } else { 
            return "redirect:/user/index";
//        }
    }
 
} 
