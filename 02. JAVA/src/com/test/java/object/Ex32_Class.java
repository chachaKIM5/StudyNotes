package com.test.java.obj;

public class Ex32_Class {

	public static void main(String[] args) {
		
		//Ex32_Class.java
		
		/*
		  
		 - 보통 자바에서는 물리적인 파일 1개에 클래스를 1개만 선언한다.
		 - 이유 > 관리 차원에서...
			-> Ex20_if 클래스에서 문제 발생 > "Ex20_if.java" 안의 클래스라는 것을 쉽게 찾을 수 있음
			-> Size 클래스에서 문제 발생? > 찾기 힘들다
			
		 - 절대규칙] 파일의 이름과 클래스의 이름이 반드시 동일해야 한다
		 	> 위반하면 컴파일 오류 발생
		 	
		 - 파일 1개에 N개의 클래스를 선언할 수 있다.
		 	> 파일 안에 N개의 클래스 중 public을 가지는 클래스는 딱 1개만 허용
		 	> public 클래스 == 대표 클래스 > 대표 클래스의 이름이 파일명이 된다.
		  
		 */
	}
}

/*
 //class Point {
  
 
	-> 오류: Ex30_Class.java에서 Point class를 만들었기 때문에
	- 클래스의 영역은 패키지까지다
	- 같은 패키지 안에는 똑같은 클래스를 만들 수 없다
	
	
}*/