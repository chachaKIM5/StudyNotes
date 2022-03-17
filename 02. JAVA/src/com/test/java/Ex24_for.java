package com.test.java;

public class Ex24_for {

	public static void main(String[] args) {
		
		//Ex24_for.java
		
		//m1_doWhile();
		//m2_for();
		//m3_Ex1_School();
		//m4_LocalVariabled();
		//m5_Ex2_9x9();
		//m6_error();
		//m7_break();
		m8();
		

	}
	
	
	private static void m8() {
		
		//별찍기
		for (int i=0 ; i<5 ; i++) { 		//행 만들기
			for (int j=0 ; j<5 ; j++) {		// 열 만들기
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		
		for (int i=0 ; i<5 ; i++) {			//행(변화X)
			for (int j=i ; j<5 ; j++) {		//열(변화 O, 5 -> 1)
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		for (int i=0 ; i<5 ; i++) { 		//행 만들기
			for (int j=0 ; j<=i ; j++) {	//열 (1 -> 5)
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		for (int i=0 ; i<5 ; i++) {
			
			for (int j=0 ; j<(4-i) ; j++) {
				System.out.print(" ");
			}
			
			//행 만들기
			for (int j=0 ; j<=i ; j++) {		// 열 만들기
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
	}


	private static void m7_break() {

		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; j<10 ; j++) {
				
				if (i == 5 || j == 5) {
					//break, continue는 자신이 "직접 포함"된 제어문만 탈출한다
					break;
				}
				
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
		
	}

	private static void m6_error() {

		//많이 하는 실수. 안쪽 for문에 j가 아니라 i를 넣어서 무한루프에 빠짐
		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; i<10 ; j++) {
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
	}

	private static void m5_Ex2_9x9() {
		
		//구구단
		//- 2단 ~ 9단 출력
		
		for (int dan=2 ; dan<=9 ; dan++) {
			
			//int dan = 2;
			
			System.out.println("==========");
			System.out.printf("    %d단\n", dan);
			System.out.println("==========");
			
			for (int i=1 ; i<=9 ; i++) {
				System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
			}
			System.out.println();
		}
	}

	private static void m4_LocalVariabled() {
		//지역 변수
		//- 메소드와 제어문 내에서 선언한 변수
		
		if (true) {
			int a = 10;
			System.out.println(a);
		}
		
		if (true) {
			int a = 20;
			System.out.println(a);
		}
		
		//a는 중복되어도 에러가 없음
		//int a는 제어문 안이 자기 영역인 지역변수이기 때문에
		//바깥에서 a를 사용하고 싶다면? if문 밖에서 먼저 int a를 선언
	}

	private static void m3_Ex1_school() {
		
		//학교, 총 3학년, 학년당 10반, 반마다 30명 학생

		for (int i=1 ; i<=3 ; i++) {
			for (int j=1 ; j<=10 ; j++) {
				for (int k=1 ; k<=30 ; k++) {
					System.out.printf("%d학년 %d반 %d번 학생\n", i, j, k);
				}
			}
		}
	}

	private static void m2_for() {
		
		/*
		 
		 제어문 중첩
		 - 모든 제어문은 종류에 상관없이 서로 중첩할 수 있다.
		 
		 
		 for문(반복문)끼리 중첩
		 - 다중 반복문
		 - 단일 for문
		 - 2중 for문
		 - 3중 for문
		 
		 */
		
		
		//단일 for문
		for (int i=0 ; i<10 ; i++) {
			System.out.println("단일 for문입니다. i: " + i);
		}

		//2중 for문
		for (int i=0 ; i<10 ; i++) {

			for (int j=0 ; j<10 ; j++) {
			
				//System.out.println("안녕하세요."); //100번 실행
				System.out.printf("2중 for문입니다. i: %d, j: %d\n", i, j);
			}
		}
		
		
		//3중 for문
		
		for (int i=0 ; i<24 ; i++) {
			
			for (int j=0 ; j<60 ; j++) {
				
				for (int k=0 ; k<60 ; k++) {
					
					System.out.printf("3중 for문입니다. i: %d, j: %d, k: %d\n", i, j, k);
				}
			}
		}

	}

	private static void m1_doWhile() {
		
		//do while문
		
		/* while문과 do while문의 차이
		 * 조건에 무관하게 한 번은 실행하게 되는 do while문
		 * 사용할 일이 정말 별로 없다
		 
		//while: 선 조건 후 반복
		while (조건) {
			실행문;
		}
		
		
		//do while: 선 실행(반복) 후 조건
		do {
			실행문;
		} while (조건);  -> do while
		
			
		*/
		
		
		int num = 0;
		do {
			System.out.println(num);
			num++;
		} while (num < 10);		
	}
}
