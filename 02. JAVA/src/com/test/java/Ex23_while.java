package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex23_while {

	public static void main(String[] args) throws Exception {
		
		//Ex23_while.java
		
		/*
		 
		 반복문
		 1. for
		 2. while
		 3. do while
		 4. for
		 
		 */
		
		//m1();
		//m2();
		//m3();
		m4();
	
		
	}

	private static void m4() throws Exception {
		
		//추후 프로젝트 할 때 참고하기
		
		//루프: 메뉴 출력 > 선택 > 실행 > 다시 메뉴로 돌아가기
		
		//학생 관리 시스템
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean loop = true;
		
		while (loop) {

			System.out.println("================");
			System.out.println("학생 관리 시스템");
			System.out.println("================");
			System.out.println("1. 학생 등록하기");
			System.out.println("2. 학생 목록보기");
			System.out.println("3. 학생 성적처리");
			System.out.println("4. 학생 상담일지");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: ");
			
			String sel = reader.readLine();

			if (sel.equals("1")) {
				//학생 등록하기
				add();
				
			} else if (sel.equals("2")) {
				//학생 목록보기
				list();
				
			} else if (sel.equals("3")) {
				//학생 성적처리
				
			} else if (sel.equals("4")) {
				//학생 상담일지
				
				
			} else {
				//프로그램 종료
				loop = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}

	private static void list() {
		
	}

	private static void add() {
		
	}

	private static void m3() {

		//구구단
		int dan = 5;
		int n = 1;
		
		while (n<=9) {
			System.out.printf("%d x %d = %d\n", dan, n, dan * n);
			n++;
		}
		
	}

	private static void m2() {
	//1~100 사이 값 누적하기
		
		int sum = 0;
		
		int n = 1;
		while (n <= 100) {
			sum += n;
			n++;
		}
		
		System.out.println(sum);
		
		
	}

	private static void m1() {
		
		/*
		 	
		 	for (초기식; 조건식; 증감식) {
		 	}
		 	
		 	- 반복 실행
		 	while (조건식) {
		 	}
		 	
		 	- 1회 실행
		 	if (조건식) {
		 	}
			
			- for문, while문은 서로 완전 대체재
		 	  100% 호환 가능!
		 */
		
		
//		int num = 10;
//		
//		if (num > 0) {
//			System.out.println("양수");
//		}
//		
//		
//		while (num > 0) {
//			System.out.println("양수");
//		}

		//for문과 while문의 비교
		//for은 형식이 까다롭게 정해져 있고 while문은 더 자유롭게 표현할 수 있다
		
		//요구사항] 1 ~ 10까지 출력하시오.
		for (int i=1 ; i<=10 ; i++) { 	//초기식 ; 조건식 ; 증감식
			System.out.println(i);
		}
		
		System.out.println();
		System.out.println();
		
		int num = 1;					//초기식
		while (num <= 10) {				//조건식
			System.out.println(num);
			num++;						//증감식
		}
		
	}
}
