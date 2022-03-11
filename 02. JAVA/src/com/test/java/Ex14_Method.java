package com.test.java;

public class Ex14_Method {

	public static void main(String[] args) {
	
		
		//Ex13_Method.java
		//메소드와 반환자료형, 리턴문(반환문)
		
		/*
		
		public static void hello() {
			System.out.println();
			
		}
		
		접근지정자	정적키워드 반환자료형 메소드명	인자리스트 {

			구현코드
			업무코드(비즈니스 코드)

		}
		
		*/
		
		
		/*
		
		메소드 매개변수
		- 호출 -> (데이터) -> 메소드
		
		메소드 반환값
		- 메소드가 실행된 뒤 호출한 곳에 값을 돌려주는 행동
		- 메소드 -> (데이터) -> 호출
		- 사용 목적 > 메소드 내 업무 진행 결과를 이어서 사용하고 싶을 때
		
		*/
		
		
		System.out.println(getNum());
		int num = getNum();
		System.out.println(num);
		
		int age = 25;
		String result = checkAge(age);
		
		System.out.println(result);
		
		
	}//main
	
	public static int getNum() { //error: This method must return a result of type int
			
		//리턴문, 반환문
		//- getNum을 호출한 곳에 아래의 값을 돌려준다.
		//- 하나의 값만 반환 가능하다.
		//- 선언부에 적힌 자료형의 값을 돌려줘야 한다.

		//return "문자열"; > error
		return 10;
			
	}
	
	
	public static void test() {

		//return값 없을 때 void
		//return 100; > error

	}
	
	
	public static String checkAge(int age) {
	
		String result = age >= 19 ? "성인" : "미성년자";
		
		return result;
		
	}
	
	
}
