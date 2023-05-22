package com.campusdiaries.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> { 
	
	 List<User> findByRole(String role);
	 
	 User findByEmailAndPassword(String email, String password);

	 boolean existsByEmail(String email);

} 
