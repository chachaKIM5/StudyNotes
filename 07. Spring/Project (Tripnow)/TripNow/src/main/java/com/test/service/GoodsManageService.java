package com.test.service;


import java.util.List;

import com.test.dto.ActivityListDTO;
import com.test.dto.CarListDTO;
import com.test.dto.HomeListDTO;

public interface GoodsManageService {

	List<HomeListDTO> homelist();

	List<CarListDTO> carlist();

	List<ActivityListDTO> activitylist();

	int homenoshow(String seq);

	int homeshow(String seq);

	String homeselect(String seq);
	
	int carnoshow(String seq);

	int carshow(String seq);

	String carselect(String seq);

	int activitynoshow(String seq);

	int activityshow(String seq);

	String activityselect(String seq);

	List<HomeListDTO> homesearch(String searchword);

	List<CarListDTO> carsearch(String searchword);

	List<ActivityListDTO> activitysearch(String searchword);

}
