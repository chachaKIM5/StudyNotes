package com.test.admin.stats;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.admin.qna.QnADAO;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private StatsDAO dao;
	
	@Override
	public List<StatsDTO> getHomeStats() {
		
		Calendar now = Calendar.getInstance();
		int nMonth = now.get(Calendar.MONTH) + 1;
		List<StatsDTO> homestats = dao.getHomeStats(nMonth);
		
		return homestats;
	}
	
	@Override
	public List<StatsDTO> getCarStats() {

		Calendar now = Calendar.getInstance();
		int nMonth = now.get(Calendar.MONTH) + 1;
		List<StatsDTO> carstats = dao.getCarStats(nMonth);
		
		return carstats;
	}
	
	@Override
	public List<StatsDTO> getActStats() {
		
		Calendar now = Calendar.getInstance();
		int nMonth = now.get(Calendar.MONTH) + 1;
		List<StatsDTO> actstats = dao.getActStats(nMonth);
		
		return actstats;
	}
	
	@Override
	public List<GenderDTO> getGStats() {
		
		Calendar now = Calendar.getInstance();
		int nMonth = now.get(Calendar.MONTH) + 1;
		List<GenderDTO> gstats = dao.getGStats(nMonth);
		Collections.reverse(gstats);
		
		return gstats;
		
	}

}
