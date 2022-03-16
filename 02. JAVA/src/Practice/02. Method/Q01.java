package com.test.java.question.method;

public class Q01 {

	public static void main(String[] args) {
		
		/*
		 
		프로세스
		1. 메소드 선언 (메소드명 hello, introduce, bye)
		2. 각 메소드 바디에 "안녕하세요.", "저는 홍길동입니다.", "안녕히가세요." 출력되도록 코딩
		3. 메소드 호출 > 실행
		 		  
		 */

		
		hello();
		introduce();
		bye();
		
		
	} //main
	
	public static void hello() {
		
		System.out.println("안녕하세요.");
		
	}
	
	public static void introduce() {
		
		System.out.println("저는 홍길동입니다.");
		
	}
	
	public static void bye() {
		
		System.out.println("안녕히가세요.");
		
	}
	
}
