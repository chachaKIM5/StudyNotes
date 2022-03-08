package com.test.java;

public class Ex03_Variable {
	
	public static void main(String[] args) {


//		Ex03_Variable.java
//	
//		변수 = Variable = 사용자가 할당받은 메모리의 공간.
//		- 개발자가 명령어를 사용해서 메모리에 할당받은 공간. 그 주소를 기억하기 위해 이름을 붙임
//		- 목적: 원하는 데이터를 읽거나 쓰기 위한 공간		
//		
//		변수
//		1. 생성하기: 변수 선언
//			- 명령어: "자료형 변수명;"
		
		byte kor;
		// = 공간 1byte를 주고 이름을 kor라고 붙여 주세요
		
//		2. 초기화하기: 변수 초기화
//			- 명령어: "변수명 = 값;"
		kor = 100;
		// = kor의 공간에 100이라는 값을 넣어 주세요
		
//		3. 사용하기
		System.out.println(kor);
		// = kor을 찾아가서 그 안의 데이터를 꺼내 화면에 출력해라
		System.out.println(100);
		// 실행 시 결과는 같지만 이게 무슨 표현인지 의미를 알 수 없다
		// 변수명(kor=국어점수)을 가지고 의미를 알 수 있음
		// 그래서 변수 이름은 a, b, c 보다는 kor, eng, math처럼 알아볼 수 있도록 정하기
		
	}
}
