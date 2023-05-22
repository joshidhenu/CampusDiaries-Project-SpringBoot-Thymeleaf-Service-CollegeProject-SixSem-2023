package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.TempUserDAO; 
import com.campusdiaries.entity.TempUser; 
import com.campusdiaries.service.TempUserService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempUserServiceImpl implements TempUserService { 

@Autowired
 private TempUserDAO tempUserDao;
 
 @Override 
    public List<TempUser> getAllTempUser() { 
        return tempUserDao.findAll(); 
    } 

@Override 
  public TempUser loadTempUserById(Integer id) {
 return tempUserDao.findById(id).orElseThrow(() -> new EntityNotFoundException("TempUser with ID " + id + " Not Found"));
 }

@Override 
    public TempUser createOrUpdateTempUser(TempUser tempUser) {
return tempUserDao.save(tempUser);
   }

  @Override
 	    public void removeTempUser(Integer id) {
 	        tempUserDao.deleteById(id);
 	    }

}
