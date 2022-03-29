package com.test.java;

public class Item50 {
	
	public static void main(String[] args) {
		
	
	/*
	 	
	 	클래스의 종류
	 	
 		 0. 클래스
		 	- 실체화를 한다 > 즉 객체를 만든다.
		 	- 구현된 멤버를 가진다. > 멤버 변수, 멤버 메소드({body})
		 
		 1. 인터페이스
		 	- 실체화 불가능 > 객체를 만들 수 없다.
		 	- 추상 멤버를 가진다. > 추상 메소드
		 	- 자바에 한해서는 다른 것도 넣을 수 있지만... 보통 추상 메소드만
		 	- 클래스의 부모 역할 > 표준화(사용법 강제 통일) + 자격 부여
		 	- 인터페이스에 한해 다중 상속이 가능하다
		 
		 2. 추상 클래스
		  	- 클래스와 인터페이스의 중간
		  	- 실체화가 불가능 > 객체를 만들 수 없다
		  	- 구현된 멤버를 가진다 > 멤버 변수, 멤버 메소드({body})
		  	- 추상 멤버를 가진다 > 추상 메소드
		  	
		 3. enum
		 	- 클래스의 일종
		 	- final public static 상수를 열거한 형태 (변수명은 대문자로 적는다)
		 	
		 4. 제네릭 클래스
	 	

	 */
	
 	색상 color1 = 색상.노랑;
 	색상 color2 = 색상.파랑;
 	System.out.println(color1);
 	System.out.println(color2);
 	//color1 = 색상.빨강; -> 수정 불가능, final 변수기 때문에

	}//main
} //Item50




//1. 인터페이스

interface 인터페이스명 {
	//추상 메소드
}

class interfaceTest implements 인터페이스명 {
	//추상 메소드 오버라이딩 (필수)
}



//2. 추상 클래스

abstract class 추상클래스명 {
	//구현 멤버 (멤버 변수, 메소드)
	private int num;
	public String str;
	public void meth() {
		
	}
	
	//추상 멤버
	public abstract void 추상멤버명();
}


class abstractTest extends 추상클래스명 {
	public void 추상멤버명() {
		//추상 메소드 오버라이딩 (필수)
	}
}



//3. enum = 열거형

enum 열거형명 {
	열거멤버1,   //final public static 변수 = 상수
	열거멤버2,   //열거형명=자료형명으로 (열거형명 변수명 = 열거형명.열거멤버1)와 같이 사용한다
	열거멤버3
}

enum 색상 {
	노랑,
	파랑,
	빨강
}

