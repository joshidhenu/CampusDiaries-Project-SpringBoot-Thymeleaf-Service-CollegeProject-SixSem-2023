package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.StaffMaster;

public interface StaffMasterDAO extends JpaRepository<StaffMaster, Integer> { 

} 
