package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.repository.IMemberDAO;
import com.test.repository.TestDAO;

import lombok.RequiredArgsConstructor;

//어노테이션 방식으로 만든 컨트롤러
// - @Controller > @Component > @Bean > 스프링이 생성하고 관리하는 객체
// - 위의 어노테이션이 동작하려면 지정된 공간(패키지) 내에 있어야 한다
//@Controller
//public class DIController {
//	
//	@GetMapping("/test")
//	public String test() {
//		return "test";
//	}
//}


//의존 주입 1.
//- 가장 정석
//- 생성자 주입
//- @Autowired 사용 X
//- 생성자가 유일해야 한다.
//- 의존 주입 방법 중 유일하게 final 변수 가능
//@Controller
//public class DIController {
//	
//	private TestDAO dao;
//	//private final TestDAO dao;
//	
//	public DIController(TestDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 2.
// - 생성자 주입
// - 생성자가 여러개라면?
//@Controller
//public class DIController {
//	
//	private TestDAO dao;
//	
//	public DIController() {
//		
//	}
//	
//	//의존 주입에 사용할 생성자라고 역할을 지정해준다
//	@Autowired
//	public DIController(TestDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 3.
// - 의존 객체가 클래스가 아니라 인터페이스 구현 객체일 때
// - 인터페이스 변수에 의존 객체 삽입 > (내부) > 스프링이 해당 인터페이스의 구현 객체(클래스)를 찾아서 객체화를 한다
//@Controller
//public class DIController {
//	
//	private IMemberDAO dao;
//	
//	public DIController(IMemberDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 4.
// - Setter 주입
// - @Autowired가 필요하다
// - 여러 Setter 중 의존 주입에 사용할 Setter를 지정한다
//@Controller
//public class DIController {
//	
//	private IMemberDAO dao;
//	
//	@Autowired
//	private void setDao(IMemberDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 5.
// - 의존 주입을 여러번 하는 경우
//@Controller
//public class DIController {
//	
//	private TestDAO dao;
//	private IMemberDAO mdao;
//	
//	private DIController(TestDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println(mdao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 6.
// - 필드 주입
// - 직접 멤버 변수에 @Autowired를 적용
//@Controller
//public class DIController {
//
//	@Autowired
//	private TestDAO dao;
//		
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 7.
// - 인터페이스 사용
// - 인터페이스 구현 객체가 여러개라면? > 에러... 이런 상황을 만들면 안 됨!
// - com.test.controller.DIController required a single bean, but 2 were found
// - -> 하나를 선택해 주기
//		- DAO를 찾아가서 둘 중 하나를 지정 @Primary 어노테이션 추가로 붙여주기
// - 의존주입용으로 사용하는 인터페이스는 반드시 클래스를 1개만 만든다
//@Controller
//public class DIController {
//	
//	@Autowired
//	@Qualifier("adminDAO")
//	private IMemberDAO dao;
//	
//	public DIController(IMemberDAO dao) {
//		this.dao = dao;
//	}
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}


//의존 주입 8.
//- 생성자 주입 + Lombok
//- @RequiredArgsConstructor > 멤버가 있는 생성자를 만들어 준다 > final 필드를 자동으로 매개변수로 넣는다
//@Controller
//@RequiredArgsConstructor //Lombok
//public class DIController {
//	
//	private final TestDAO dao;
//	
//	@GetMapping("/test")
//	public String test() {
//		
//		System.out.println(dao.test());
//		System.out.println();
//		
//		return "test";
//	}
//}



@Controller
@RequiredArgsConstructor
public class DIController {
	
	private final TestDAO dao;
	
	@GetMapping("/test")
	public String test(Model model) {
		
		List<String> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "test";
	}
}