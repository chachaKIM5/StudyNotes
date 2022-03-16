package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex20_if {

	public static void main(String[] args) throws Exception {
		
		//Ex20_if.java
		
		//알고리즘 > 제어문
		//자료구조 > 배열(컬렉션)
		
		
		/*
	
		제어문
		- 수많은 명령어들의 흐름(실행 순서)을 통제하는 역할
		- 조건 제어, 반복 제어, 분기 제어
		
		1. 조건문
			- 개발자가 조건을 제시한 후 프로그램의 흐름을 제어한다.
			a. if
			b. switch
			
		2. 반복문
			- 특정 코드를 개발자가 원하는 횟수만큼 반복 실행한다.
			a. for
			b. while
			c. do while
			d. for > foreach
			
		3. 분기문
			- 개발자가 코드의 흐름을 원하는 곳으로 이동한다.
			- 독립적으로 사용되지 않고 다른 제어문에 섞여서 사용된다.
			a. break
			b. continue
			c. goto(JDK 1.5에서 폐기)
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();

	}//main

	private static void m5() {

		/*
		 
		  	조건의 조건식
		  	- boolean값이어야만 한다. (반드시)
		  	- JAVA는 C계열 언어이다.
		  	- C언어는 boolean형이 없다. > 정수 사용(1, 0) > boolean 자료형 생성
		  	
		  	- 정수: 0(false), 1(true), 0이 아닌 모든 숫자(true)
		  	- 실수: 0.0(false), 0이 아닌 모든 숫자(true)
		  	- 문자: \0(null 문자, 문자코드값(0))(false), 그 이외 모든 문자(true)
		  	- 문자열: ""(빈문자열)(false), "홍길동"(true)
		  
		 */
		
	}

	private static void m4() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//요구사항] 성적을 입력받고 합격(60점 이상)/불합격(60점 미만) 통보
		
		System.out.print("성적: ");
		int score = Integer.parseInt(reader.readLine());
		
		//데이터의 자격 > 0 ~ 100 > 유효성 검사 
		
//		if (score >= 60) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
		
		//조건 3개
		//1 (score >= 60 && score <= 100)
		//2. (score >= 0 && score <= 59)
		//3. 100보다 크거나 0보다 작을 때
		
		if (score >= 60 && score <= 100) {
			System.out.println("합격");
		} else if (score >= 0 && score <= 59) {
			System.out.println("불합격");
		} else {
			System.out.println("점수는 0~100 사이로 입력하세요.");
		}

		
		
		//조건
		//1. (score >= 0 && score <= 100)
		//	1.1 (score >= 60)
		//	1.2 else절
		//2. 1의 불만족
		
		//중첩 if문
		if (score >= 0 && score <= 100) {
				
			if (score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		
		} else {
			System.out.println("점수는 0~100 사이로 입력하세요.");
		}

	}//m4

	private static void m3() throws Exception {
		
		//보기 > 선택
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0; //누적 변수
		
		System.out.println("A. 무슨 색을 좋아합니까?");
		System.out.println("1. 검정색");
		System.out.println("2. 노란색");
		System.out.println("3. 파란색");
		
		System.out.print("선택: ");
		
		String input = reader.readLine();
		
		if (input.equals("1")) {
			sum = 10;
		} else if (input.equals("2")) {
			sum = 5;
		} else if (input.equals("3")) {
			sum = 3;
		}

		System.out.println("B. 어떤 언어를 선호합니까?");
		System.out.println("1. JAVA");
		System.out.println("2. C#");
		System.out.println("3. C++");
		
		System.out.print("선택: ");
		
		input = reader.readLine();
		
		if (input.equals("1")) {
			sum += 5;
		} else if (input.equals("2")) {
			sum += 3;
		} else if (input.equals("3")) {
			sum += 7;
		}
		
		
		System.out.println("완료되었습니다.");
		System.out.println("[결과]");
		
		if (sum > 15) {
			System.out.println("당신은 진취적인 개발자입니다.");
		} else if (sum <= 15 && sum >= 10) {
			System.out.println("당신은 평범한 개발자입니다.");
		} else {
			System.out.println("다른 일을 찾아보세요.");
		}
		
		
		
	}

	private static void m2() throws Exception {

		//요구사항] 나이를 입력받아 성인/미성년자 출력하기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("나이: ");
		int age = Integer.parseInt(reader.readLine());
		
		String result = age >= 19 ? "성인" : "미성년자";
		System.out.println(result);
		
		
		if (age >= 19) {
			result = "성인";
		} else {
			result = "미성년자";
		}
		System.out.println(result);

	}

	private static void m1() {

		/*
		  
		 	if 문
		 	- 개발자가 조건을 제시한 후 프로그램의 흐름을 제어한다
		 	- 조건문 > boolean 값을 가진다.
		 	
		 	조건문의 기본 형식 (단일 조건문)
		 	if (조건문) {
		 	 	실행문; 
		 	}
		 	
		 	
		 	조건문의 변형 (단일 조건문)
		 	if (조건식) {
		 		실행문;
		 	} else {
		 		실행문;
		 	}
		 	
		 	
		 	조건문의 변형 2: 다중 조건문
		 	if (조건식) {
		 		실행문;
		 	} else if (조건식) {
		 		실행문;
		 	}
		 	
		 	조건문의 변형 3: 다중 조건문
		 	[]: 사용해도 되고, 생략해도 된다.
		 	x N: 횟수는 자유롭게.
		 	if (조건식) {
		 		실행문;
		 	}
		 	
		 	[else if (조건식) {
		 		실행문;
		 	}] X N
		 	
		 	[else {
		 		실행문;
		 	}]
		 	
		 */
		
		boolean flag = true;
		
		//해당 블럭을 조건부 실행 > true일 때만 실행
		if (flag) {
			
			System.out.println("참입니다.");
			
		}
		
		
		
		int n = 10;
		
		if (n > 0) {
			System.out.println("양수입니다.");
		}
		
		
		if (n > 0) {
			
			System.out.println("양수입니다.");
		
		} else {
			
			System.out.println("음수입니다.");
			
		}
		
		
		n = 10;
				
		if (n > 0) {
			System.out.println("양수입니다.");
		} else if (n < 0) {
			System.out.println("음수입니다.");
		} else {
			System.out.println("0입니다.");
		}
		
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		
		

		
		
	}
}
