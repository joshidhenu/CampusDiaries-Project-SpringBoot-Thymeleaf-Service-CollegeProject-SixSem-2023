package com.campusdiaries.service;

import com.campusdiaries.entity.StudentMaster;
import java.util.List;

public interface StudentMasterService { 

  List<StudentMaster> getAllStudentMaster();

StudentMaster loadStudentMasterById(Integer id );

StudentMaster createOrUpdateStudentMaster(StudentMaster studentMaster);

void removeStudentMaster(Integer id);

} 
