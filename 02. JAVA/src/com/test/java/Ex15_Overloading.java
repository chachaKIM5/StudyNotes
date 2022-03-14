package com.test.java;

public class Ex15_Overloading {

	public static void main(String[] args) {

		// Ex15_Overloading.java

		/*
		  
		 메소드 오버로딩, Method Overloading
		 - 메소드가 인자 리스트를 다양한 형태로 가질 수 있는 기술
		 - 같은 이름의 메소드 + 인자를 다양하게 > 여러 개 만들 수 있는 기술
		  
		 - 같은 메소드명을 가진 메소드를 여러 개 만들려면 매개변수의 자료형이 달라야 함
		 - 메소드 오버로딩을 하는 이유?: 메소드 이름을 외우기 힘들 경우를 위해
		 
		 
		 메소드 오버로딩 구현 조건 가능
		 1. 매개변수의 갯수
		 2. 매개변수의 자료형
		 
		 메소드 오버로딩 구현 조건 불가능
		 1. 매개변수의 이름
		 2. 반환값의 자료형
		
		 ***** 오버로딩 구현 조건의 기준을 메소드를 호출하면서 생각해보기 (검증!) *****
		 메소드 선언 시
		 a. public static void test() {}
		 b. public static void test() {} 				//X, a와 중복
		 c. public static void test(int n) {}			//O
		 d. public static void test(int m) {}			//X, c와 중복
		 e. public static void test(String s) {}		//O
		 f. public static void test(int n, int m) {} 	//O
		 g. public static int test() {}					//X, a와 중복
		
		 
		 */

		drawLine(); // drawLineEquals()

		drawLine("*"); // drawLineAsterisk()
		drawLine("+"); // drawLinePlus()
		drawLine("$"); // drawLineDollar()

	}// main

	// 메소드 생성 > 이름?
	// 식별자가 비슷하게 중복될 때 숫자를 붙이는 행동 절대 금지! > 의미가 불분명하기 때문에
	public static void drawLine() {

		System.out.println("==============================");
	}

	// public static void drawLine() {
	//
	// System.out.println("*******************************");
	// }

	public static void drawLine(String s) {

		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.print(s);
		System.out.println();
	}

	private static String test1() {

		// 자주 쓰는 Method 관련 단축 기능
		// 1. 호출 구문 > 메소드 자동 생성(Ctrl + 1 > create)
		// 2. 블럭 선택 > refactor > extract method

		// printf() > 형식 문자 사용 > 출력할 때 사용만 가능
		// 10 / 3 -> "3.3"

		System.out.println(10 / 3); 			// 3
		System.out.println(10.0 / 3); 			// 3.33333333333333

		System.out.printf("%.1f\n", 10.0 / 3);	// 3.3
		// 3.3을 출력이 아니라 return값으로 쓰려면?

		// 1. 자바 수학 기능
		// 2. 형식 문자열 지원 메소드


		// 1. 자바의 Math 수학 기능
		System.out.println(Math.round(10.0 / 3 * 10) / 10.0); // 3.3
		// return String.valueOf(Math.round(10.0 / 3 * 10 / 10.0));


		// 2. String.format 메소드
		// printf 메소드와 기능은 동일하지만 > 결과를 출력(X) 결과를 반환(O)
		String result = String.format("%.1f", 10.0 / 3);

		return result;
	}

}

/*
	코드 컨벤션
	- 프로그래밍 코드 작성 시 지켜야 할 규칙
	
	구글 + 자바 코딩 + 코드 컨벤션

1. 수동 적용 > Ctrl + Shift + F
2. 자동 적용 (저장할 때) > preference > "save actions"

*/
