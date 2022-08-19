package com.test.dao;

import java.util.List;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;

public interface EventDAO {
	
//	List<EventDTO> list();

	EventDTO get(String seq);

	int edit(EventDTO edto);

	int getSeq();

	int addevent(EventDTO edto);

	int countEvent(String column, String word);

	List<EventDTO> eventList(PagingDTO pdto, String column, String word);

	

	

	



}
