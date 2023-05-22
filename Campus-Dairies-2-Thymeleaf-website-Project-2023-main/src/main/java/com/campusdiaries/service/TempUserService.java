package com.campusdiaries.service;

import com.campusdiaries.entity.TempUser;
import java.util.List;

public interface TempUserService { 

  List<TempUser> getAllTempUser();

TempUser loadTempUserById(Integer id );

TempUser createOrUpdateTempUser(TempUser tempUser);

void removeTempUser(Integer id);

} 
