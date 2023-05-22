package com.campusdiaries.service;

import com.campusdiaries.entity.EventRegistration;
import java.util.List;

public interface EventRegistrationService { 

  List<EventRegistration> getAllEventRegistration();

EventRegistration loadEventRegistrationById(Integer id );

EventRegistration createOrUpdateEventRegistration(EventRegistration eventRegistration);

void removeEventRegistration(Integer id);

} 
