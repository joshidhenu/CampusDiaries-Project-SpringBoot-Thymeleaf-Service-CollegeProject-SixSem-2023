package com.campusdiaries.service;

import java.util.Date;
import java.util.List;

import com.campusdiaries.entity.Event;

public interface EventService {

	List<Event> getAllEvent();

	Event loadEventById(Integer id);

	Event createOrUpdateEvent(Event event);

	void removeEvent(Integer id);

	List<Event> findAllByLastDate(Date date);

	List<Event> findAllByStartDate(Date date);

}
