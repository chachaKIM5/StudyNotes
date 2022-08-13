package com.test.admin;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/admin/main")
	public String main() {
		
		
		return "admin.main.main";
	}
	
	@GetMapping("/admin/qna/list")
	public String qnaList(Model model, String page) {
		
		HashMap<String, String> map = service.pagenation(page);
		List<QnADTO> list = service.getQnAList(map);
		List<QnADTO> nlist = service.getQnANoticeList();
		String pagebar = service.getPagebar(map);
		
		model.addAttribute("nowPage", map.get("nowPage"));
		model.addAttribute("pagebar", pagebar);
		model.addAttribute("list", list);
		model.addAttribute("nlist", nlist);
		return "admin.qna.list";
	}
	
	
	@GetMapping("/admin/qna/view/{seq}")
	public String qnaList(Model model, String page, String notice, @PathVariable String seq) {
		
		QnADTO dto = service.getView(seq);
		
		model.addAttribute("nowPage", page);
		model.addAttribute("isNotice", notice);
		model.addAttribute("dto", dto);
		
		return "admin.qna.view";
	}
	
	
	@GetMapping("/admin/qna/add")
	public String qnaAdd() {
	
		return "admin.qna.add";
	}
	
	@PostMapping("/admin/qna/addok")
	public String qnaAddNotice(Model model, QnADTO dto) {
		
		int result = service.addNotice(dto);
		model.addAttribute("result", result);
		
		return "admin.qna.addok";
	}
	
	
	@ResponseBody
	@PostMapping("/admin/qna/answer")
	public Object addanswer(QnADTO dto) {
		
		QnADTO result = service.addAnswer(dto);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("acontent", result.getAcontent());
		map.put("aregdate", result.getAregdate());
		
		return map;
	}
	
	@ResponseBody
	@PostMapping("/admin/qna/delanswer")
	public String delanswer(String qseq) {
		
		int result = service.delAnswer(qseq);
		
		return String.valueOf(result);
	}
	
	
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
