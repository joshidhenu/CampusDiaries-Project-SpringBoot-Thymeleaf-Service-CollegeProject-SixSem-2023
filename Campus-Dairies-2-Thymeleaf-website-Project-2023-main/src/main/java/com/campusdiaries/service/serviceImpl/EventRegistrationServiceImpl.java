package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.EventRegistrationDAO; 
import com.campusdiaries.entity.EventRegistration; 
import com.campusdiaries.service.EventRegistrationService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EventRegistrationServiceImpl implements EventRegistrationService { 

@Autowired
 private EventRegistrationDAO eventRegistrationDao;
 
 @Override 
    public List<EventRegistration> getAllEventRegistration() { 
        return eventRegistrationDao.findAll(); 
    } 

@Override 
  public EventRegistration loadEventRegistrationById(Integer id) {
 return eventRegistrationDao.findById(id).orElseThrow(() -> new EntityNotFoundException("EventRegistration with ID " + id + " Not Found"));
 }

@Override 
    public EventRegistration createOrUpdateEventRegistration(EventRegistration eventRegistration) {
return eventRegistrationDao.save(eventRegistration);
   }

  @Override
 	    public void removeEventRegistration(Integer id) {
 	        eventRegistrationDao.deleteById(id);
 	    }

}
