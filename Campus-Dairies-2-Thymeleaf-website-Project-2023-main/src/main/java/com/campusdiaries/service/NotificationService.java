package com.campusdiaries.service;

import com.campusdiaries.entity.Notification;
import java.util.List;

public interface NotificationService { 

  List<Notification> getAllNotification();

Notification loadNotificationById(Integer id );

Notification createOrUpdateNotification(Notification notification);

void removeNotification(Integer id);

} 
