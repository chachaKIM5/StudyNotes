package com.test.spring;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex05Controller {

	@GetMapping(value="/add")
	public String add() {
		
		return "add";
	}
	
	
	//form 태그의 값 받아오기 -> 매개변수에 HttpServletRequest 만들기
	//response, session 필요할 때도 만들어주면 됨! 순서 상관 X
//	@PostMapping(value="/addok")
//	public String addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
//		
//		String num = req.getParameter("num");
//		
//		req.setAttribute("num", num);
//		
//		return "addok";
//	}
	
	
	//방식 A
	//한글 깨지지 않도록 인코딩? 
//	@PostMapping(value="/addok")
//	public String addok(HttpServletRequest req) {
//		
//		//req.setCharacterEncoding("UTF-8");
//		
//		
//		String num = req.getParameter("num");
//		
//		req.setAttribute("num", num);
//		
//		return "addok";
//	}

	//방식 B
	//방식 A와 비슷하지만 Spring에서는 어노테이션 활용 가능
//	@PostMapping(value="/addok")
//	public String addok(@RequestParam("num") String num) {
//				
//		System.out.println(num);
//		
//		return "addok";
//	}
	
	
	//방식 C-1: 단일 데이터
	//어노테이션도 생략, form태그의 name과 매개변수 이름이 같게 하기
	//Model 만들기 > addok.jsp로 전달
//	@PostMapping(value="/addok")
//	public String addok(String num, Model model) {
//		
//		System.out.println(num);
//		model.addAttribute("num", num);
//		
//		return "addok";
//	}

	
	//방식 C-2: 다중 데이터
//	@PostMapping(value="/addok")
//	public String addok(@RequestParam("name") String name,
//						@RequestParam("age") String age,
//						@RequestParam("address") String address,
//						Model model) {
		

	//방식 C-3: 다중 데이터 -> DTO
//	@PostMapping(value="/addok")
//	public String addok(String name, String age, String address, Model model) {
//		
////		model.addAttribute("name", name);
////		model.addAttribute("age", age);
////		model.addAttribute("address", address);
//		
//		SpringDTO dto = new SpringDTO();
//		
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setAddress(address);
//	
//		model.addAttribute("dto", dto);
//		return "addok";
//	}

	//방식 C-4 (*****)
	//매개변수에 dto를 넣는 것만으로 dto 속성들을 변수로 받아서 dto 만들고 포장까지 ok
	//form태그의 name과 dto의 setter 이름이 같으면 자동으로! ***
//	@PostMapping(value="/addok")
//	public String addok(Model model, SpringDTO dto) {
//		
//		model.addAttribute("dto", dto);
//		
//		return "addok";
//	}
	
	@PostMapping(value="/addok")
	public String addok(Model model, String[] cb) {
		
		//String[] cb = req.getParameterValues("cb");
		model.addAttribute("cb", cb);
		
		return "addok";
	}
}
