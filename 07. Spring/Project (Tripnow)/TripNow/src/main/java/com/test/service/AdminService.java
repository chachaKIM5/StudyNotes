package com.test.service;

import java.util.List;

import com.test.dto.ActDTO;
import com.test.dto.ActOptionDTO;
import com.test.dto.CarDTO;
import com.test.dto.CarOptionDTO;
import com.test.dto.HomeDTO;
import com.test.dto.HomeOptionDTO;

public interface AdminService {

	List<CarDTO> clist();

	List<HomeDTO> hlist();

	List<ActDTO> alist();

	CarOptionDTO coption(CarDTO dto);

	int carrefusal(String seq);

	int carcheck(String seq);

	ActOptionDTO aoption(ActDTO dto);

	List<String> apath(ActDTO dto);

	int actrefusal(String seq);

	int actcheck(String seq);

	HomeOptionDTO hoption(HomeDTO dto);

	List<String> fpath(HomeDTO dto);

	int homerefusal(String seq);

	int homecheck(String seq);

	

	

}
