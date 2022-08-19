package com.test.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.GoodsManageDAO;
import com.test.dto.ActivityListDTO;
import com.test.dto.CarListDTO;
import com.test.dto.HomeListDTO;

@Service
public class GoodsManageServiceImpl implements GoodsManageService {
	
	@Autowired
	private GoodsManageDAO dao;
	
	@Override
	public List<HomeListDTO> homelist() {
		
		return dao.homelist();
	}
	
	@Override
	public List<CarListDTO> carlist() {

		return dao.carlist();
	}
	
	@Override
	public List<ActivityListDTO> activitylist() {
		
		return dao.activitylist();
	}
	
	@Override
	public int homenoshow(String seq) {
		
		return dao.homenoshow(seq);
	}
	
	@Override
	public int homeshow(String seq) {
		
		return dao.homeshow(seq);
	}
	
	@Override
	public String homeselect(String seq) {
		
		return dao.homeselect(seq);
	}
	
	@Override
	public int carnoshow(String seq) {

		return dao.carnoshow(seq);
	}
	
	@Override
	public int carshow(String seq) {
		
		return dao.carshow(seq);
	}
	
	@Override
	public String carselect(String seq) {
		
		return dao.carselect(seq);
	}
	
	@Override
	public int activitynoshow(String seq) {
		
		return dao.activitynoshow(seq);
	}
	
	@Override
	public int activityshow(String seq) {
		
		return dao.activityshow(seq);
	}
	
	@Override
	public String activityselect(String seq) {
		
		return dao.activityselect(seq);
	}
	
	@Override
	public List<ActivityListDTO> activitysearch(String searchword) {
		
		return dao.activitysearch(searchword);
	}
	
	@Override
	public List<CarListDTO> carsearch(String searchword) {
		
		return dao.carsearch(searchword);
	}
	
	@Override
	public List<HomeListDTO> homesearch(String searchword) {
		
		return dao.homesearch(searchword);
	}

}
