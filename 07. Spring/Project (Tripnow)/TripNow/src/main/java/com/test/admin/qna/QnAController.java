package com.test.admin.qna;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QnAController {

	@Autowired
	private QnAService service;
	
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
	
	
}
