package com.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.dto.ActDTO;
import com.test.dto.ActOptionDTO;
import com.test.dto.CarDTO;
import com.test.dto.CarOptionDTO;
import com.test.dto.HomeDTO;
import com.test.dto.HomeOptionDTO;

@Repository
@Component("clist")
public class AdminDAOImpl implements AdminDAO{

	private SqlSessionTemplate template;
	
	@Autowired
	public AdminDAOImpl(SqlSessionTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<CarDTO> clist() {
		
		return this.template.selectList("mapper.clist");
	}
	
	@Override
	public List<HomeDTO> hlist() {

		return this.template.selectList("mapper.hlist");
	}
	
	@Override
	public List<ActDTO> alist() {

		return this.template.selectList("mapper.alist");
	}
	
	@Override
	public CarOptionDTO coption(CarDTO dto) {
		
		System.out.println(dto.getSeq());
		
		return this.template.selectOne("mapper.coption", dto);
	}
	
	@Override
	public ActOptionDTO aoption(ActDTO dto) {

		return this.template.selectOne("mapper.aoption", dto);
	}
	
	@Override
	public HomeOptionDTO hoption(HomeDTO dto) {

		return this.template.selectOne("mapper.hoption", dto);
	}
	
	@Override
	public int carrefusal(String seq) {

		return this.template.update("mapper.carrefusal", seq);
	}
	
	@Override
	public int carcheck(String seq) {

		return this.template.update("mapper.carcheck", seq);
	}
	
	@Override
	public List<String> apath(ActDTO dto) {

		return this.template.selectList("mapper.apath", dto);
	}
	
	@Override
	public List<String> fpath(HomeDTO dto) {

		return this.template.selectList("mapper.fpath", dto);
	}
	
	@Override
	public int actrefusal(String seq) {

		return this.template.update("mapper.actrefusal", seq);
	}
	
	@Override
	public int actcheck(String seq) {

		return this.template.update("mapper.actcheck", seq);
	}
	
	@Override
	public int homerefusal(String seq) {

		return this.template.update("mapper.homerefusal", seq);
	}
	
	@Override
	public int homecheck(String seq) {

		return this.template.update("mapper.homecheck", seq);
	}
	
	
}





































