package com.test.spring.thymeleaf;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ThymeleafController {

	private AddressDAO dao;
	
	@Autowired
	public ThymeleafController(AddressDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/m1")
	public void m1() {
		
		System.out.println("m1");
		//반환값이 없어도 스프링과 동일하게 "m1.html"을 찾는다
		
	}
	
	@GetMapping("/m2")
	public String m2() {
		
		System.out.println("m2");
		
		//"m2" > 어디에 있는 어떤 페이지를 가리키는지?
		// - 위치 > sr/main/resources/templates (=views)
		// - 확장자 > .html
		// - 동적 페이지: http://localhost:8090/m2 -> templates + *.html 검색
		// - 정적 페이지: http://localhost:8090/m2.html -> static의 페이지 검색
		return "m2";
	}
	
	
	@GetMapping("/m3")
	public String m3(Model model) {
		
		int num = dao.num();
		String txt = dao.txt();
		Calendar now = dao.now();
		AddressDTO dto = dao.get();
		Map<String, Integer> map = dao.map();
		
		
		model.addAttribute("num", num);
		model.addAttribute("txt", txt);
		model.addAttribute("now", now);
		model.addAttribute("dto", dto);
		model.addAttribute("map", map);
		
		return "m3";
	}

	@GetMapping("/m4")
	public String m4(Model model) {
			
		return "m4";
	}
	
	@GetMapping("/m5")
	public String m5(Model model) {
		
		int a = 10;
		int b = 3;
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		return "m5";
	}
	
	@GetMapping("/m6")
	public String m6(Model model) {
		
		model.addAttribute("s1", "age");
		model.addAttribute("size", 30);
		
		model.addAttribute("color", "cornflowerblue");
		
		return "m6";
	}
	
	@GetMapping("/m7")
	public String m7(Model model) {
		
		String txt = "<u>홍길동</u>입니다.";
		AddressDTO dto = dao.get();
		Map<String,Integer> map = dao.map();
		List<String> names = dao.names();
		List<AddressDTO> list = dao.list();
		
		model.addAttribute("txt", txt);
		model.addAttribute("dto", dto);
		model.addAttribute("map", map);
		model.addAttribute("names", names);
		model.addAttribute("list", list);
		
		
		return "m7";
	}

	@GetMapping("/m14")
	public String m14() {
		
		return "m14";
	}

	@GetMapping("/m15")
	public String m15(Model model) {
		
		//리스트형
		
		List<AddressDTO> list = dao.list();
		model.addAttribute("list", list);
	
		return "m15";
	}

	@GetMapping("/m16")
	public String m16(Model model) {
		
		//카드형
		
		List<AddressDTO> list = dao.list();
		model.addAttribute("list", list);
		
		return "m16";
	}
	
	@GetMapping("/m17")
	public String m17(Model model) {
		
		return "m17"; //templates/m17.html
	}
	
	
}
