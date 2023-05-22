package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.StudentMaster;

public interface StudentMasterDAO extends JpaRepository<StudentMaster, Integer> { 

} 
