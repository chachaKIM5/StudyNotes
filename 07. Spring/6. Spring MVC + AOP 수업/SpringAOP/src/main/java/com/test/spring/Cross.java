package com.test.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
@Aspect		//@Component로 만들어진 bean태그에 보조 업무 객체의 자격을 부여하기
@Component 	//bean태그 만들기
public class Cross {

	
	//주업무 지정 > 포인트컷 생성
	//@Pointcut("AspectJ 표현식")
	
	@Pointcut("execution(public String com.test.spring.AOPController.test())")
	public void pc1() {
		//자바 Class 영역에 포인트컷을 생성하기 위한 껍데기 > 구현 X
	}
	
	//보조 업무 선언 + 주업무 결합(위빙)
	//Advice어노테이션("포인트컷메소드")
	@After("pc1()")
	public void m1() {
		
		System.out.println("보조 업무");
		
	}
	
	@Before("pc1()")
	public void m2() {
		
		System.out.println("보조 업무2");
	}
	
	
}
