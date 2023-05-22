package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.StudentMasterDAO; 
import com.campusdiaries.entity.StudentMaster; 
import com.campusdiaries.service.StudentMasterService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentMasterServiceImpl implements StudentMasterService { 

@Autowired
 private StudentMasterDAO studentMasterDao;
 
 @Override 
    public List<StudentMaster> getAllStudentMaster() { 
        return studentMasterDao.findAll(); 
    } 

@Override 
  public StudentMaster loadStudentMasterById(Integer id) {
 return studentMasterDao.findById(id).orElseThrow(() -> new EntityNotFoundException("StudentMaster with ID " + id + " Not Found"));
 }

@Override 
    public StudentMaster createOrUpdateStudentMaster(StudentMaster studentMaster) {
return studentMasterDao.save(studentMaster);
   }

  @Override
 	    public void removeStudentMaster(Integer id) {
 	        studentMasterDao.deleteById(id);
 	    }

}
