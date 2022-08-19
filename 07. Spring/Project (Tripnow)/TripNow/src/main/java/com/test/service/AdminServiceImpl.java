package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AdminDAO;
import com.test.dto.ActDTO;
import com.test.dto.ActOptionDTO;
import com.test.dto.CarDTO;
import com.test.dto.CarOptionDTO;
import com.test.dto.HomeDTO;
import com.test.dto.HomeOptionDTO;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminDAO dao;
	
	@Autowired
	public AdminServiceImpl(AdminDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CarDTO> clist() {

		return dao.clist();
	}
	
	@Override
	public List<HomeDTO> hlist() {

		return dao.hlist();
	}
	
	@Override
	public List<ActDTO> alist() {
	
		return dao.alist();
	}
	
	@Override
	public CarOptionDTO coption(CarDTO dto) {

		return dao.coption(dto);
	}
	
	@Override
	public ActOptionDTO aoption(ActDTO dto) {

		return dao.aoption(dto);
	}
	
	@Override
	public HomeOptionDTO hoption(HomeDTO dto) {

		return dao.hoption(dto);
	}
	
	@Override
	public int carrefusal(String seq) {

		return dao.carrefusal(seq);
	}
	
	@Override
	public int carcheck(String seq) {

		return dao.carcheck(seq);
	}
	
	
	@Override
	public List<String> apath(ActDTO dto) {

		return dao.apath(dto);
	}
	
	@Override
	public List<String> fpath(HomeDTO dto) {

		return dao.fpath(dto);
	}
	
	@Override
	public int actrefusal(String seq) {

		return dao.actrefusal(seq);
	}
	
	@Override
	public int actcheck(String seq) {

		return dao.actcheck(seq);
	}
	
	@Override
	public int homerefusal(String seq) {

		return dao.homerefusal(seq);
	}
	
	@Override
	public int homecheck(String seq) {

		return dao.homecheck(seq);
	}
	
	
}






























