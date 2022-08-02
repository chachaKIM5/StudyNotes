package com.test.spring;

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

@Controller
public class BoardController {

	private BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping(value="/test")
	public String test() {
		
		return "test";
	}
	
	@GetMapping(value="/login")
	public String login(HttpSession session, String id, HttpServletRequest req) {
		
		session.setAttribute("auth", id); //로그인
		
		return "redirect:/list";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, HttpServletRequest req) {
		
		session.removeAttribute("auth"); //로그아웃
		
		return "redirect:/list";
	}
	
	@GetMapping(value="/add")
	public String add(HttpSession session, HttpServletResponse resp, HttpServletRequest req) {
		
		return "add";
	}
	
	@PostMapping(value="/addok")
	public void addok(HttpSession session, HttpServletResponse resp, BoardDTO dto, HttpServletRequest req) {
		
		dto.setId((String)session.getAttribute("auth"));
		
		int result = service.add(dto);
		
		try {
			
			if (result == 1) {
				
				resp.sendRedirect("/spring/list");
				
			} else {
				PrintWriter writer = resp.getWriter();
				writer.println("<script>");
				writer.println("alert('failed');");
				writer.println("location.href='/spring/add';");
				writer.println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/list")
	public String list(Model model, HttpServletRequest req, HttpSession session) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}

	@GetMapping(value="/view")
	public String view(HttpSession session, HttpServletResponse resp, Model model, String seq, HttpServletRequest req) {
		
		BoardDTO dto = service.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
}
