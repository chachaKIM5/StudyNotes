package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//Main > 컨트롤러 (주 업무를 통제하는 역할)
		
		//주업무 객체 직접 만들기
		//Memo memo = new MemoImpl();
		
		
		//주업무 객체를 직접 만들지 않고 Spring을 통해 만들어야지만 걸어둔 AOP가 동작
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");

		
		//메모 쓰기
		memo.add("스프링 AOP 작업을 하고 있습니다.");
		
		//메모 읽기
		
		try {
			
			String txt = memo.read(5);
			txt = memo.read(15);
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		//메모 수정하기
		boolean result = memo.edit(5,  "수정한 내용입니다.");
		
		//메모 삭제하기
		result = memo.del(5);
		
	}
}
