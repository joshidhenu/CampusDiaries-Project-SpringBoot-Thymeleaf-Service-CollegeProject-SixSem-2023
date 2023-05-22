package com.campusdiaries.service;

import com.campusdiaries.entity.Suggestion;
import java.util.List;

public interface SuggestionService { 

  List<Suggestion> getAllSuggestion();

Suggestion loadSuggestionById(Integer id );

Suggestion createOrUpdateSuggestion(Suggestion suggestion);

void removeSuggestion(Integer id);

} 
