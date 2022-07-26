package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현 방식
//1. Controller 인터페이스 구현 (초창기)
//2. @Controller 어노테이션 사용

@Controller
@RequestMapping(value="/ex03.do") //.xml 방문하지 않아도 ok
public class Ex03Controller {

	//요청 메소드 > 마음대로~ but @RequestMapping 어노테이션 추가해 일반 메소드와 구분!
	/*
	 * @RequestMapping public String test() {
	 * 
	 * //업무 코드 작성 후 jsp 부르기 -> return "jsp이름"
	 * 
	 * //servlet-context.xml에 ViewResolver가 없다면? //return "/WEB-INF/views/ex03.jsp";
	 * 
	 * return "ex03"; }
	 */
	
	//요청 메소드가 void일 때 > 가상주소와 동일한 이름의 JSP를 자동으로 찾아준다 -> 잘 사용되지 않는다
	@RequestMapping
	public void test() {
		System.out.println("test");
	}
	
	public void aaa() {
		
	}
	
	public void bbb() {
		
	}

	public String ccc() {
		return "ccc";
	}

}
