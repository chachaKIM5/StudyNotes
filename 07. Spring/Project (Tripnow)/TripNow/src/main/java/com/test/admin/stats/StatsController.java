package com.test.admin.stats;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.admin.qna.QnAService;

@Controller
public class StatsController {
	
	@Autowired
	private StatsService service;

	@GetMapping("/admin/stats/view")
	public String stats(Model model) {
	
		//전체 매출 통계 (액티비티, 렌터카, 숙소) -> 당월 카테고리별 매출, 지난 6개월 간 카테고리별 매출 그래프
		//HashMap<String(월), Integer(매출)>
		
		List<StatsDTO> homestats = service.getHomeStats();
		List<StatsDTO> carstats = service.getCarStats();
		List<StatsDTO> actstats = service.getActStats();
		
		
		model.addAttribute("homestats", homestats);
		model.addAttribute("carstats", carstats);
		model.addAttribute("actstats", actstats);
		
		//상품 구매자 성별 통계 (남/여 -> 지난 6개월 간)
		//결제 -> 예약리스트 -> 각 카테고리 예약 -> 아이디의 성별 join해서 월별로 가져오기
		
		List<GenderDTO> gstats = service.getGStats();
		
		
		model.addAttribute("gstats", gstats);
		
		Calendar now = Calendar.getInstance();
		int nMonth = now.get(Calendar.MONTH) + 1;
		
		model.addAttribute("nmonth", nMonth);
		
		return "admin.stats.view";
	}
}
