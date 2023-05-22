package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.StaffMasterDAO; 
import com.campusdiaries.entity.StaffMaster; 
import com.campusdiaries.service.StaffMasterService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StaffMasterServiceImpl implements StaffMasterService { 

@Autowired
 private StaffMasterDAO staffMasterDao;
 
 @Override 
    public List<StaffMaster> getAllStaffMaster() { 
        return staffMasterDao.findAll(); 
    } 

@Override 
  public StaffMaster loadStaffMasterById(Integer id) {
 return staffMasterDao.findById(id).orElseThrow(() -> new EntityNotFoundException("StaffMaster with ID " + id + " Not Found"));
 }

@Override 
    public StaffMaster createOrUpdateStaffMaster(StaffMaster staffMaster) {
return staffMasterDao.save(staffMaster);
   }

  @Override
 	    public void removeStaffMaster(Integer id) {
 	        staffMasterDao.deleteById(id);
 	    }

}
