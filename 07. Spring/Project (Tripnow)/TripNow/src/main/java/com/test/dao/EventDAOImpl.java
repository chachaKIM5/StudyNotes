package com.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;

@Repository
public class EventDAOImpl implements EventDAO{
	
	private SqlSessionTemplate template;
	
	@Autowired
	public EventDAOImpl(SqlSessionTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<EventDTO> eventList(PagingDTO pdto,String column ,String word) {
		
		pdto.setColumn(column);
		pdto.setWord(word);
		
		return this.template.selectList("event.eventList", pdto);
	}
	
//	@Override
//	public List<EventDTO> list() {
//		
//		
//		return this.template.selectList("event.list");
//	}


	@Override
	public EventDTO get(String seq) {
		
		
		return this.template.selectOne("event.get", seq);
	}


	@Override
	public int edit(EventDTO edto) {
		
		return this.template.update("event.edit", edto);
	}


	@Override
	public int getSeq() {
		
		return this.template.selectOne("event.getSeq");
	}


	@Override
	public int addevent(EventDTO edto) {
		
		return this.template.insert("event.addevent", edto);
	}


	@Override
	public int countEvent(String column, String word) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("word", word);
		
		return this.template.selectOne("event.countEvent",map);
	}




}
