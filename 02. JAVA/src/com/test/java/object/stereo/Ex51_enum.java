package com.test.java.obj.stereo;

public class Ex51_enum {

	public static void main(String[] args) {
		
		//Ex51_enum.java
		
		//클래스 종류
		//1. 클래스
		//2. 인터페이스
		//3. 추상 클래스
		//4. enum
		//5. 제네릭 클래스

		//열거형, Enumeration
		// - 클래스의 일종
		// - 열거형 멤버는 final public static 상수이기 때문에 대문자로 적는다
		
		
		//요구사항] 의류 쇼핑몰 > 티셔츠 > 고객 > 색상 선택(빨강, 노랑, 파랑)
		
		
		//Case 1. 주관식
		String color = "빨강"; //오타 발생 확률 높지만 에러는 안 생김
		
		if (color.equals("빨강") || color.equals("노랑") || color.equals("파랑")) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		
		//Case 2. 열거형 = 객관식
		//생산성 ↑ 안정성 ↑
		//열거형 리터럴 표기법
		//색상이라는 자료형으로 만든 c1 변수 = 색상 열거형(enum) 중 빨강
		색상 c1 = 색상.빨강; //오타 나면 에러 생김
		색상 c2 = 색상.파랑;
		
		
		if (c1 == 색상.빨강 || c1 == 색상.노랑 || c1 == 색상.파랑) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		int c3 = 색상2.노랑;
		
		if (c3 == 색상2.빨강 || c3 == 색상2.노랑 || c3 == 색상2.파랑) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		
		
		직급 position = 직급.사원;
		
		Gender g1 = Gender.MALE;
		Gender g2 = Gender.FEMALE;
		
		
	}//main
}//Ex51


class 클래스명 {
	//구현 멤버
}

interface 인터페이스명 {
	//추상 멤버
}

abstract class 추상클래스명 {
	//구현 멤버
	//추상 멤버
}

enum 열거형명 {
	//열거형 멤버
}



//열거형 선언하기
enum 색상 {
	빨강, //final static 변수 = 상수
	노랑,
	파랑
}


//위 enum열거형과 똑같이 class로 표현하기
class 색상2 {
	final public static int 빨강 = 0; 
	final public static int 노랑 = 1; 
	final public static int 파랑 = 2; 
}


enum 직급 {
	사원,
	대리,
	과장,
	부장
}



enum Gender {
	MALE,
	FEMALE
}