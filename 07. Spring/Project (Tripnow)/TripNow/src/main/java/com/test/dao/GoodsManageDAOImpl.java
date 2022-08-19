package com.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.ActivityListDTO;
import com.test.dto.CarListDTO;
import com.test.dto.HomeListDTO;

@Repository
public class GoodsManageDAOImpl implements GoodsManageDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<HomeListDTO> homelist() {
		
		return template.selectList("mapper.homelist");
	}
	
	@Override
	public List<CarListDTO> carlist() {
		
		return template.selectList("mapper.carlist");
	}
	
	@Override
	public List<ActivityListDTO> activitylist() {
		
		return template.selectList("mapper.activitylist");
	}
	
	@Override
	public int homenoshow(String seq) {
		
		return template.update("mapper.homenoshow", seq);
	}
	
	@Override
	public int homeshow(String seq) {
		
		return template.update("mapper.homeshow", seq);
	}
	
	@Override
	public String homeselect(String seq) {
		
		return template.selectOne("mapper.homeselect", seq);
	}
	
	@Override
	public int carnoshow(String seq) {
		
		return template.update("mapper.carnoshow", seq);
	}
	
	@Override
	public int carshow(String seq) {
		
		return template.update("mapper.carshow", seq);
	}
	
	@Override
	public String carselect(String seq) {

		return template.selectOne("mapper.carselect", seq);
	}
	
	@Override
	public int activitynoshow(String seq) {
		
		return template.update("mapper.activitynoshow", seq);
	}
	
	@Override
	public int activityshow(String seq) {
		
		return template.update("mapper.activityshow", seq);
	}
	
	@Override
	public String activityselect(String seq) {
		
		return template.selectOne("mapper.activityselect", seq);
	}
	
	@Override
	public List<ActivityListDTO> activitysearch(String searchword) {
		
		return template.selectList("mapper.activitysearch", searchword);
	}
	
	@Override
	public List<CarListDTO> carsearch(String searchword) {
		
		return template.selectList("mapper.carsearch", searchword);
	}
	
	@Override
	public List<HomeListDTO> homesearch(String searchword) {
		
		return template.selectList("mapper.homesearch", searchword);
	}
	
}
