package com.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;

public interface EventService {
	
//	List<EventDTO> list();
	
//	List<EventDTO> list(PagingDTO dto, String nowPage, String cntPerPage);

	EventDTO get(String seq);

	int editevent(EventDTO edto, HttpServletRequest req);

	int addevent(EventDTO edto, HttpServletRequest req);

	PagingDTO paging(String nowPage, PagingDTO pdto,String column ,String word);

	List<EventDTO> eventList(PagingDTO pdto,String column ,String word);

	

	

}
