package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.SuggestionDAO; 
import com.campusdiaries.entity.Suggestion; 
import com.campusdiaries.service.SuggestionService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService { 

@Autowired
 private SuggestionDAO suggestionDao;
 
 @Override 
    public List<Suggestion> getAllSuggestion() { 
        return suggestionDao.findAll(); 
    } 

@Override 
  public Suggestion loadSuggestionById(Integer id) {
 return suggestionDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Suggestion with ID " + id + " Not Found"));
 }

@Override 
    public Suggestion createOrUpdateSuggestion(Suggestion suggestion) {
return suggestionDao.save(suggestion);
   }

  @Override
 	    public void removeSuggestion(Integer id) {
 	        suggestionDao.deleteById(id);
 	    }

}
