package com.test.spring.thymeleaf;

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
		model.addAttribute("num", num);
		
		return "m3";
	}
	
}
