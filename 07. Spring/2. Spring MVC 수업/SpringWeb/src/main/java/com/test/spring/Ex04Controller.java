package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
//가상주소 spring/board/ex04.do로 결합
public class Ex04Controller {

	@RequestMapping(value="/ex04.do")
	public String test() {
		
		return "ex04";
	}

	@RequestMapping(value="/ex04_1.do")
	public String test2() {
		
		return "ex04_1";
	}
	
	@RequestMapping(value="/list.do")
	public String list() {
		
		return "list";
	}
	@RequestMapping(value="/add.do")
	public String add() {
		
		return "add";
	}
	
	//RequestMapping은 method=RequestMethod.GET|POST 생략하면 GET, POST 모든 요청에 반응한다
	//method를 POST로 -> addok.do는 주소창으로 접근 불가능
	//생략하지 않고 항상 적어주는 게 좋다!
	@RequestMapping(value="/addok.do", method=RequestMethod.POST)
	public String addok() {
		
		return "addok";
	}
	
	
	@RequestMapping(value="/edit.do", method=RequestMethod.GET)
	public String edit() {
		
		return "edit";
	}
	
	@RequestMapping(value="/editok.do", method=RequestMethod.POST)
	public String editok() {
		
		return "editok";
	}
	
	
	//GetMapping, PostMapping 어노테이션은 Spring 버전에 따라 지원여부 다름
	//Spring lagacy project는 정해진 버전으로 만들어짐 -> 스프링 버전 올리기 -> pom.xml
	//수업 때에는 스프링 5.0.7 버전 사용!
	//pom.xml에서 수정
	//org.springframework-version 5.0.7
	//java-version 1.11, 프로젝트 오른쪽 마우스 -> Properties, Project Facets에서 Java를 11로...
	//maven-compiler-plugin의 source, target 1.11, version 3.5.1
	@GetMapping(value="/del.do")
	public String del() {
		
		return "del";
	}
	
	@PostMapping(value="/delok.do")
	public String delok() {
		
		return "delok";
	}
	
}
