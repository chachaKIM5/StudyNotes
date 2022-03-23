package com.test.java.obj;

public class Ex31_Class {

	public static void main(String[] args) {
		
		//Ex31_Class.java
		
		//변수
		//1. 지역 변수
		//2. 멤버 변수
		
		//메소드
		//1. 멤버 메소드
		
		
		//클래스 멤버
		//- 멤버 변수
		//- 멤버 메소드
		
		
		User u1 = new User();
		u1.info();
		
		User u2 = new User();
		
		u2.info();
	
		User u3 = new User();
		u3.info();
		
		
		System.out.println("---------------------");
		//32행 위, 아래는 결과가 같다
		
		User u4 = new User();
		u4.info();
		u4.info();
		u4.info();
		
		System.out.println();
		
		
		
		//하나의 클래스로부터 만들어진 객체는 형태와 역할이 동일하다.
		//- m1과 m2는 검은색 볼펜, 빨간색 볼펜과 같다 >
		//- 잉크 색깔: 객체 상태(State, 멤버 변수)의 차이로 구분이 가능하다.
		//- 객체 상태는 객체와 객체를 구분짓는 데 가장 주요한 기준.
		
		//객체의 유일성
		Member m1 = new Member();
		m1.id = "hong";
		m1.info();
		
		
		Member m2 = new Member();
		m2.id = "lee";
		m2.info();
		
	
	} //main
}


class User {
	
	public void info() {
		
		//정적
		System.out.println("회원의 정보를 출력합니다.");
		
	}
	
}




class Member {
	
	public String id;
	
	//멤버 메소드는 구현할 때 멤버 변수를 활용해야 진정한 가치를 가지게 된다.
	public void info() {
		System.out.println("회원의 정보를 출력합니다.");
		System.out.printf("아이디: %s\n", id); //본인의 멤버 변수를 활용 > 상태 활용
	}
	
}