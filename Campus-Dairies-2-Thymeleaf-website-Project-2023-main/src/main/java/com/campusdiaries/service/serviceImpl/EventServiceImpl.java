package com.campusdiaries.service.serviceImpl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.EventDAO;
import com.campusdiaries.entity.Event;
import com.campusdiaries.service.EventService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDao;

	@Override
	public List<Event> getAllEvent() {
		return eventDao.findAll();
	}

	@Override
	public Event loadEventById(Integer id) {
		return eventDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Event with ID " + id + " Not Found"));
	}

	@Override
	public Event createOrUpdateEvent(Event event) {
		return eventDao.save(event);
	}

	@Override
	public void removeEvent(Integer id) {
		eventDao.deleteById(id);
	}

	@Override
	public List<Event> findAllByLastDate(Date date) {
		
		return eventDao.findByLastDateLessThan(date);
		
	}

	@Override
	public List<Event> findAllByStartDate(Date date) {

		return eventDao.findByStartDateGreaterThan(date);
	}

}
