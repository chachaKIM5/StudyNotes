package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBatisController {

	//MyBatisController > (의존) > MyBatisService > (의존) > MyBatisDAO

	//Spring DI 어노테이션
	//@Autowired를 만남 -> @Component가 붙어 있는 MyBatisService 클래스를 찾아감 -> @Component가 bean 태그를 만들어 Spring이 인식!
	@Autowired
	private MyBatisService service;
	
//	@Autowired
//	public MyBatisController(MyBatisService service) {
//		this.service = service;
//	}
	
	@GetMapping(value="/test")
	public String test() {
		
		//MyBatisService service = new MyBatisServiceImpl();
		
		System.out.println("1. MyBatisService is null = " + (this.service == null));
		
		service.test();
		
		return "result";
	}
	
//	@GetMapping(value="/m1")
//	public String m1(Model model) {
//		
//		return "result";
//	}
	
	@GetMapping(value="/m1")
	public String m1(Model model) {
		
		//정적 쿼리 > 인자값 X, 반환값 X
		service.m1();
		
		return "result";
	}
	
	@GetMapping(value="/m2")
	public String m2(Model model, String seq) {
		
		//인자값 O
		// > seq 전달 > 가격 인상
		
		//http://localhost:8090/spring/m2?seq=1
		
		int result = service.m2(seq);
		model.addAttribute("result", result);
		
		return "result";
	}

	@GetMapping(value="/m3")
	public String m3(Model model, String seq) {
		
		int result = service.m3(seq);
		
		model.addAttribute("result", result);
		return "result";
	}
	
	@GetMapping(value="/m4")
	public String m4(Model model, MyBatisDTO dto) {
		
		int result = service.m4(dto);
		
		model.addAttribute("result", result);
		return "result";
	}

	
	
	@GetMapping(value="/m5")
	public String m5(Model model, String seq) {

		//인자값 O, 반환값 O
		//seq > 가격을 Select 해오기
		
		int price = service.m5(seq);
		
		model.addAttribute("price", price);
		return "result";
	}

	@GetMapping(value="/m6")
	public String m6(Model model, String seq) {
		
		//인자값 O, 반환값 O
		//seq > 모든 정보를 Select 해오기
		
		MyBatisDTO dto = service.m6(seq);
		
		model.addAttribute("dto", dto);
		return "result";
	}
	
	@GetMapping(value="/m7")
	public String m7(Model model) {
		
		List<String> nlist = service.m7();
		
		model.addAttribute("nlist", nlist);
		return "result";
	}

	@GetMapping(value="/m8")
	public String m8(Model model) {
		
		List<MyBatisDTO> list = service.m8();
		
		model.addAttribute("list", list);
		return "result";
	}
	
	@GetMapping(value="/m9")
	public String m9(Model model, String table) {
		
		//select count(*) from 테이블이름;
		int count = service.m9(table);
		
		model.addAttribute("count", count);
		return "result";
	}

	@GetMapping(value="/m10")
	public String m10(Model model, String word) {
		
		//변수 word로 item 이름 검색하기
		List<MyBatisDTO> list = service.m10(word);
		
		model.addAttribute("list", list);
		return "result";
	}
	
	@GetMapping(value="/m11")
	public String m11(Model model, String type) {
		
		//employees + type
		//type 1. first_name
		//type 2. last_name
		
		List<String> nlist = service.m11(type);
		
		model.addAttribute("nlist", nlist);
		return "result";
	}
}

