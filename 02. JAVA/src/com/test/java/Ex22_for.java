package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex22_for {

	public static void main(String[] args) throws Exception {
		
		//Ex22_for.java
	
		/*
		 
		 반복문
		  - 동일한 코드를 여러 번 실행하고 싶을 때?
		  - 특정 코드를 개발자가 원하는 횟수만큼 반복 실행한다.
		  - 생산성 향상 + 유지보수성
		 
		 for (초기식; 조건식; 증감식) {
		 	 실행문;
		 }
		 		 
		 */
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
		//m11();
		
	} //main

	private static void m11() {
		//난수, Random
		//- 임의의 수
		//- 난수 생성기
		
		//1. Math.random()
		//2. Random 클래스
		
		//0 ~ 0.9999999999999
		//0 이상 1 미만의 값, double 자료형
		//System.out.println(Math.random());
		

		
		//1~10 사이의 난수를 구하려면?
		//A: 최솟값
		//A+B-1: 최댓값
		//(int)(Math.random() * B) + A
		for (int i=0; i<10; i++) {
			
			int num = (int)(Math.random() * 7) + 3;
			
			System.out.println(num);
		}
	}

	private static void m10() {
		
		//m9와 같은 요구사항을 Calendar로 만들어 보자
		
		Calendar start = Calendar.getInstance();
		start.set(2022, 2, 1); //시작 날짜 만들기: 2022년 3월 1일
		
		//start가 속한 달의 최대값을 가져와라: 마지막 날짜! 윤년 계산도 알아서 해줌
		//System.out.println(start.getActualMaximum(Calendar.DATE));
		
		int lastDay = start.getActualMaximum(Calendar.DATE);
		
		for (int i=1; i<=lastDay; i++) {
			
			System.out.printf("%d년 %d월 %d일 %tA\n"
								, start.get(Calendar.YEAR)
								, start.get(Calendar.MONTH) + 1
								, start.get(Calendar.DATE), start);
			
			start.add(Calendar.DATE, 1);
		}
		
		
		
	}

	private static void m9() {
		
		//요구사항] 2022년 3월 1일 ~ 3월 31일까지 날짜 출력
		//2022년 3월 1일
		//2022년 3월 2일
		//~
		//2022년 3월 31일
		
		for (int date=1; date<=31; date++) {
			
			System.out.printf("2022년 3월 %d일\n", date);
		}
		
		
		
		//요구사항 추가] 2022년 3월 1일 ~ 3월 31일까지 날짜 + 요일을 같이 찍기
		
		for (int date=1; date<=31; date++) {
			
			String day = getDay(date);
			
			System.out.printf("2022년 3월 %02d일 %s요일\n", date, day);
			
		}
		
	}

	public static String getDay(int date) {
	
		if (date % 7 == 1) {
			return "화";
		} else if (date % 7 == 2) {
			return "수";
		} else if (date % 7 == 3) {
			return "목";
		} else if (date % 7 == 4) {
			return "금";
		} else if (date % 7 == 5) {
			return "토";
		} else if (date % 7 == 6) {
			return "일";
		} else if (date % 7 == 0) {
			return "월";
		}
		
		return "";
		
		//error message = This method must return a result of type String
		//if문 안에 모두 return문 넣었는데도 오류?
		//> 모든 경우의 수에 return이 존재해야 하는데, 일부 경우에 존재하지 않을 수도 있어서.
		//- 해결 방법 2개!
		//if문 밖에 return ""; or return null
		//마지막 else if절을 지우고 else로 바꾸기, 조건식 지우기
		
	}
	
	private static void m8() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		//요구사항] 사용자가 입력한 숫자 중 짝수만 누적, 0을 입력하면 종료

		for (;;) {
			
			System.out.print("숫자를 입력하세요.: ");
			
			int num = Integer.parseInt(reader.readLine());
			
				if (num == 0) {
					break;
				}
				
				if (num % 2 == 1) {
					continue;
				}
				
				sum += num;
		}
		
		System.out.println("최종 합: " + sum);
		
	}

	private static void m7() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//요구사항] 사용자가 숫자 입력하면 누적, 횟수를 사용자 맘대로, 0을 입력하면 종료
		
		int sum = 0;
		for (;;) {
			
			System.out.print("숫자를 입력하세요.: ");
			int num = Integer.parseInt(reader.readLine());
				
				if (num == 0)  {
					break;
				}
				
			sum += num;
		
		} System.out.println("최종 합: " + sum);
		
	}

	private static void m6() {
		
		//무한 루프, Infinite Loop
//		아래와 같이 ++이 아니라 --로 실수한다면? 계속 "안녕하세요." 출력
//		for (int i=0; i<10; i--) { //int 특성 때문에 21억 바퀴까지라 따지고 보면 '무한' 루프는 아님
//			
//			System.out.println("안녕하세요.");
//		}
		
		
		//무한 루프 만들기: 초기식, 조건식, 증감식에 아무것도 안 넣기
		//단지 무한으로 실행해야 할 때
//		for (;;) {
//			System.out.println("무한 루프");	
//		}
		
		//무한 루프 만들기: 조건식에 아무것도 안 넣기
		//무한으로 실행하면서 루프 변수도 필요할 때
//		for (int i=2100000000; ; i++) {
//			System.out.println(i);
//		}
		
		//무한 루프 만들기: 조건식에 true 넣기도 함
		//무한으로 실행하면서 루프 변수도 필요할 때
//		for (int i=0; true; i++) {
//			System.out.println(i);
//		}
		
		for (int i=0; true; i++) {
			System.out.println(i);
			
			if (i>100000) {
				break;
			}
		}

		//루프 탈출하는 방법
		for (int i=1; i<=10; i++) {
			System.out.println(i);
			
			if (i == 5) {
				break; //"if문을 제외한" 나머지 제어문을 탈출하는 역할 (*********)
			}
			
		}
		
		System.out.println();
		
		
		
		for (int i=1; i<=10; i++) {
			
			if (i == 5) {
				continue; //for문에 대해 동작, 하던 일을 멈추고 제어의 처음으로 돌아가도록 함
			}
			
			System.out.println(i);
		}
	}

	private static void m5() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("몇 단을 외울까요?: ");
		int dan = Integer.parseInt(reader.readLine());
		
		for (int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
		
	}

	private static void m4() throws Exception {
		
//		//요구사항] 1~10까지의 합
//		
//		int sum = 0; //누적 변수(반드시 0으로 초기화)
//		for (int i=1; i<=10; i++) 
//			sum = sum + i;
//		}

		
		//요구사항 추가] 사용자 숫자 입력 > x10번 입력 > 숫자의 합

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for (int i=0; i<=10; i++) {
			System.out.print("숫자를 입력하세요: ");
			int num = Integer.parseInt(reader.readLine());
			sum += num;
		}
		
		System.out.println(sum);
	}

	private static void m3() {
		
		//반복문 사용 이유
		//1. 반복하기 위해서 > 쉬움
		//2. 루프 변수를 사용하기 위해서(********) > 어려움, 연습 필요! > 일종의 수열을 만들어내는 것
		
		//요구사항] 숫자 1~10까지 출력
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
		
		//루프 변수의 사용
		for (int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		for (int i=1; i<=10; i+=2) {
			System.out.println(i);
		}

		for (int i=7; i<=100; i+=7) {
			System.out.println(i);
		}

	}
 
	private static void m2() {
	
		//반복문 몇 회전?
		for (int i=0; i<5; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for (int i=3; i<=7; i++) {
			System.out.println("실행문");
		}
		System.out.println();
		
		for (int i=10; i>5; i--) {
			System.out.println("실행문");
		}
		System.out.println();
	}

	private static void m1() {

		//요구사항] "안녕하세요" 5번 출력
		hello();
		hello();
		hello();
		hello();
		hello();
		
		for (int i=1; i<=5; i++) {
			hello();
		}
		
		System.out.println();
		
		
		// int i=1; 초기식: for문에 처음 진입할 때 단 1회만 실행한다
		// i<=5;	조건식: 반복 유무를 결정한다
		// i++;		증감식: 조건식의 변화를 유발한다
		
		// 반복문 > loop(iteration) > i > 루프 변수
		
		for (int i=1; i<=5; i++) {
			System.out.println("안녕하세요.");
		}
	}
	
	public static void hello() {
		System.out.println("안녕하세요.");
		
	}
}

