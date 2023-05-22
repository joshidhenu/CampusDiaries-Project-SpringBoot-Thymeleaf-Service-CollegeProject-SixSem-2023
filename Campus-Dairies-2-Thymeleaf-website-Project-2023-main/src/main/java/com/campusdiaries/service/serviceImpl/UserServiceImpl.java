package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.UserDAO; 
import com.campusdiaries.entity.User; 
import com.campusdiaries.service.UserService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService { 

@Autowired
 private UserDAO userDao;
 
 @Override 
    public List<User> getAllUser() { 
        return userDao.findAll(); 
    } 

@Override 
  public User loadUserById(Integer id) {
 return userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " Not Found"));
 }

@Override 
    public User createOrUpdateUser(User user) {
return userDao.save(user);
   }

  @Override
 	    public void removeUser(Integer id) {
 	        userDao.deleteById(id);
 	    }

@Override
public List<User> getAllUserByRole(String role) {

	return userDao.findByRole(role);
}

@Override
public User getUserByEmailandPassword(String email, String password) {
	
	return userDao.findByEmailAndPassword(email, password);
}

@Override
public boolean checkEmailExist(String email) {
	
	return userDao.existsByEmail(email);
}
}
