package com.test.admin.stats;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatsDAOImpl implements StatsDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<StatsDTO> getHomeStats(int nMonth) {
		
		ArrayList<StatsDTO> list = new ArrayList<StatsDTO>();
		
		for (int i=0 ; i<6 ; i++) {
		
			StatsDTO dto = new StatsDTO();
			dto = template.selectOne("mapper.gethomestats", nMonth);
			list.add(dto);
			nMonth--;
			
		}
		return list;
	}
	
	@Override
	public List<StatsDTO> getCarStats(int nMonth) {
		
		ArrayList<StatsDTO> list = new ArrayList<StatsDTO>();
		
		for (int i=0 ; i<6 ; i++) {
			
			StatsDTO dto = new StatsDTO();
			dto = template.selectOne("mapper.getcarstats", nMonth);
			list.add(dto);
			nMonth--;
			
		}
		return list;
	}
	
	@Override
	public List<StatsDTO> getActStats(int nMonth) {
		
		ArrayList<StatsDTO> list = new ArrayList<StatsDTO>();
		
		for (int i=0 ; i<6 ; i++) {
			
			StatsDTO dto = new StatsDTO();
			dto = template.selectOne("mapper.getactstats", nMonth);
			list.add(dto);
			nMonth--;
			
		}
		return list;
	}
	
	
	@Override
	public List<GenderDTO> getGStats(int nMonth) {
		
		ArrayList<GenderDTO> list = new ArrayList<GenderDTO>();
		
		for (int i=0 ; i<6 ; i++) {
			
			GenderDTO homedto = new GenderDTO();
			GenderDTO cardto = new GenderDTO();
			GenderDTO actdto = new GenderDTO();
			GenderDTO result = new GenderDTO();
			
			homedto = template.selectOne("mapper.gethomegstats", nMonth);
			cardto = template.selectOne("mapper.getcargstats", nMonth);
			actdto = template.selectOne("mapper.getactgstats", nMonth);
			
			result.setMonth(String.valueOf(nMonth));
			result.setMale(homedto.getMale() + cardto.getMale() + actdto.getMale());
			result.setFemale(homedto.getFemale() + cardto.getFemale() + actdto.getFemale());

			list.add(result);
			nMonth--;
			
		}
		return list;		
		
	}


}
