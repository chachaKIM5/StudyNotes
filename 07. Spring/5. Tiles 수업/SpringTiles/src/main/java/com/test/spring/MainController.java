package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	@GetMapping(value="/member/info")
	public String info() {
		
		//회원 > 정보 페이지
		
		return "one.member.info";
	}
	
	@GetMapping(value="/member/point")
	public String point() {
		
		//회원 > 포인트 페이지
		
		return "two.member.point";
	}
	
	@GetMapping(value="/admin/chart")
	public String chart() {
		
		//관리자 > 통계 데이터 페이지
		
		return "three.admin.chart";
	}
	
	@GetMapping(value="/admin/preference")
	public String preference() {
		
		//관리자 > 환경 설정 페이지
		
		return "admin.preference";
	}

	@GetMapping(value="/test")
	public String test() {
		
		//기존 ViewResolver
		//return "test" > "/WEB-INF/views/" + "test" + ".jsp"
		
		//Tiles ViewResolver
		//return "test" > <definition name="test">의 template(jsp 주소) = "레이아웃 페이지"를 호출
		return "test";
	}
}
