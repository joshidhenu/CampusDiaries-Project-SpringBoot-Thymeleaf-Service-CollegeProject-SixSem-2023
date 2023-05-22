package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.NotificationDAO; 
import com.campusdiaries.entity.Notification; 
import com.campusdiaries.service.NotificationService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService { 

@Autowired
 private NotificationDAO notificationDao;
 
 @Override 
    public List<Notification> getAllNotification() { 
        return notificationDao.findAll(); 
    } 

@Override 
  public Notification loadNotificationById(Integer id) {
 return notificationDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Notification with ID " + id + " Not Found"));
 }

@Override 
    public Notification createOrUpdateNotification(Notification notification) {
return notificationDao.save(notification);
   }

  @Override
 	    public void removeNotification(Integer id) {
 	        notificationDao.deleteById(id);
 	    }

}
