package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		
		//m1();
		m2();
		
	}

	private static void m2() {
		
		//Ex02 > Hong > Pen
		//Ex02 > Lee > Brush
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/di02/di02.xml");
		
		Hong hong = (Hong)context.getBean("hong");
		hong.run();
		
		Lee lee = (Lee)context.getBean("lee");
		lee.run();
		
		
	}

	private static void m1() {
		
		//스프링 환경 > 객체 생성 및 소멸은 스프링이 관리
		// > 관리 XML 필요
		
		//Pen 객체 "직접" 생성하기
		Pen p1 = new Pen();
		p1.write();
		
		
		//Pen 객체 "스프링으로" 생성하기
		//XML 설정 읽기 > 인식 > 호출
		//getBean(ID) 메소드 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/di02/di02.xml");
	
		//getBean(ID) -> ID(식별자)를 찾아가서 해당 클래스의 인스턴스 생성 + 반환
		//다운캐스팅 필요
		Pen p2 = (Pen)context.getBean("pen"); //id로
		p2.write();
		
		Pen p3 = (Pen)context.getBean("p1"); //name으로
		p3.write();
		
		Pen p4 = (Pen)context.getBean("p2"); //또 다른 name으로
		p4.write();
		
		Pen p5 = (Pen)context.getBean("p3"); //또 또 다른 name으로
		p5.write();
		
		// -> ID는 하나만, name은 여러 개 줄 수 있다
		
		
		Brush b2 = (Brush)context.getBean("brush");
		b2.draw();
	}
}
