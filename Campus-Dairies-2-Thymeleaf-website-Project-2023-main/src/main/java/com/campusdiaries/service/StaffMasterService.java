package com.campusdiaries.service;

import com.campusdiaries.entity.StaffMaster;
import java.util.List;

public interface StaffMasterService { 

  List<StaffMaster> getAllStaffMaster();

StaffMaster loadStaffMasterById(Integer id );

StaffMaster createOrUpdateStaffMaster(StaffMaster staffMaster);

void removeStaffMaster(Integer id);

} 
