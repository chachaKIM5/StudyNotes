package com.test.admin.event;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;
import com.test.service.EventService;

@Controller
@RequestMapping("/admin/event/")
public class EventController {
	
	private EventService eService;
	
	@Autowired
	public EventController(EventService eService) {
		this.eService = eService;
	}
	
	
	@GetMapping("eventmain")
	public String eventmain(PagingDTO pdto,Model model
							, @RequestParam(value="nowPage", required=false)String nowPage
							, @RequestParam(value="column", required=false,defaultValue="eventname")String column
							, @RequestParam(value="word", required=false,defaultValue="")String word) {
		
		pdto = eService.paging(nowPage,pdto,column,word);
		
		List<EventDTO> list = eService.eventList(pdto,column,word);

		
		model.addAttribute("paging",pdto);
		model.addAttribute("list",list);
		
		System.out.println(pdto);
		System.out.println(list);

		return "admin.event.eventmain";
	}
	
	
	
	
	
	
//	@GetMapping("eventmain")
//	public String eventmain(Model model) {
//		
//		List<EventDTO> list = eService.list();
//		
//		model.addAttribute("list",list);
//
//		return "admin.event.eventmain";
//	}
//	

	
	@GetMapping("event")
	public String view(HttpSession session, HttpServletResponse resp, Model model, String seq, HttpServletRequest req) {
		
		EventDTO dto = eService.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "admin.event.event";
	}
	
	@GetMapping("eventadd")
	public String eventadd(HttpServletResponse resp, HttpServletRequest req) {
		
		return "admin.event.eventadd";
	}
	
	@PostMapping("addok")
	public void addevent(Model model,HttpServletRequest req, HttpServletResponse resp, EventDTO edto) {
		
		int result = 0;

		result = eService.addevent(edto,req);
		
		
		try {
			if (result == 1) {
//				resp.sendRedirect("eventmain" );
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('추가완료!')");
				out.println("location.href=\"eventmain\";");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@PostMapping("editok")
	public void editevent(Model model,HttpServletRequest req, HttpServletResponse resp, EventDTO edto) {
		
		int result = 0;

		result = eService.editevent(edto,req);
		
		
		try {
			if (result == 1) {
//				resp.sendRedirect("event?seq="+ edto.getSeq() );
				
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('수정완료!')");
				out.printf(" location.href=\"event?seq= %s\"; ", edto.getSeq());
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}



















