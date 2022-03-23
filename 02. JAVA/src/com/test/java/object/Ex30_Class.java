package com.test.java.obj;

public class Ex30_Class {

	public static void main(String[] args) {
		
		//Ex30_Class.java
		
		/*
		 
		 
		 클래스, Class > 용어
		 
		 
		 1. 객체, Object
		 
		 2. 클래스, Class
		 
		 3. 인스턴스, Instance
		 
		 4. 추상화
		 
		 5. 정보 은닉(화)
		 
		 6. 인터페이스
		 
		 7. 프로퍼티, 속성, 특성
		 
		 8. 행동
		 
		 9. 상속
		 
		 
		 
		 
		 변수 사용
		 1. 변수 선언하기
		 2. 변수 사용 > 데이터 입출력의 공간으로서 역할
		 
		 
		 
		 메소드 사용
		 1. 메소드 선언하기
		 2. 메소드 사용 > 호출 > 코드 재사용의 개념
		 


		 클래스 사용
		 1. 클래스 선언하기(정의)
		 
		 	class 클래스명 {
		 		클래스 멤버 구현
		 		a. 멤버 변수
		 		b. 멤버 메소드
		 	}
		 	
				 	
		 2. 클래스 사용
		 
		 	클래스명 객체명 = new 생성자();
		 
		 */
		
		
		
		//요구사항] 지도 > 우리집, 마트 > 좌표 저장 > 호출 + 출력
		
		//Case 1.
		// - 간편, 즉시 생성
		// - 식별자 문제	> 같은 성질의 식별자가 서로 다른 이름을 사용
		//			   	> 물리적인 제약이 존재하지 않음 > 사용자 경험 근거 > 구조 불안정
		// - 생산성, 유지보수성 낮음
		
		
		//우리집 좌표
		int x = 100; //위도
		int y = 200; //경도
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", x, y);
		
		
		//마트 좌표
		int x2 = 300;
		int y2 = 400;
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", x2, y2);
		
		
		
		
		//Case 2.
		//- 배열 사용
		//- 장점: 데이터 저장의 구조 생성 > 관리가 수월(용이) > 가독성 향상
		//- 동일 성질의 데이터 > 동일한 식별자 사용(방번호)
		//- 단점 > 요소간의 성질을 구분하기 힘들다
		//- 물리적인 한 쌍을 만들어 주는 건 좋지만, 첨자를 사용하기 때문에 0번째 방과 1번째 방이 뭘 뜻하는지 알 수가 없다
		//- > *** 서로 다른 성질의 데이터를 넣으면 안 된다
		//  > *** 예시) 1명의 점수(5과목)
		int[] score = { 100, 90, 80, 70, 60 };  //X
		int[] kors = { 100, 90, 100, 90, 100 }; //O
		
		//우리집
		int[] a1 = { 100, 200 };
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", a1[0], a1[1]);
		
		
		//마트
		int[] a2 = { 300, 400 };
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", a2[0], a2[1]);
		
		
		
		
		
		
		//Case 3.
		//- 클래스 사용
		// > 클래스를 이용해서 메모리에 정의된 내용을 실체화시키는 행동
		// > = "객체 생성" (객체는 살짝 넓은 범위, 정확히는 "인스턴스")
		//- 클래스는 자료형의 역할을 한다. > 변수를 만들 수 있다.
		//- 장점: 데이터 저장의 구조 생성 > 관리 수월(용이) > 가독성 향상
		//- 단점: 데이터를 첨자(숫자)로 구분해 알아보기 배열과 비교하면.. 각 요소에 이름을 부여할 수 있다
		//		> 각 데이터가 어떤 데이터인지 식별 용이
		// - 요소의 이름이 동일하다. (p1.x, p2.x)
		
		//자료형 변수명;
		int n1;
		
		//클래스(설계도)를 사용해서 Heap 공간에 객체를 만든다
		//Stack의 p1 = 참조변수 = 객체변수 
		Point p1 = new Point();
		
		
		//우리집	
		//객체(변수).멤버변수 > '.'은 멤버 접근 연산자
		p1.x = 100;
		p1.y = 200;
			
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", p1.x, p1.y);
		
		
		//마트
		Point p2 = new Point();
		p2.x = 300;
		p2.y = 400;
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", p2.x, p2.y);
		
		
		
		//자바의 자료형
		//1. 기본 부품(단일 레고 블럭) > 원시형=값형 8종류
		//2. 조합 부품(블럭 조합) > 새로운 모양 창조 > 참조형(문자열, 배열, 클래스... 무한대)
		
		
		
		
		//요구사항2] 크기 저장 > 너비(width) + 높이(height)
		
		Size s1 = new Size(); //메모리에 name, width, height 변수 생긴다
		s1.name = "모니터";
		s1.width = 100;
		s1.height = 200;
		
		System.out.println(s1.name);
		System.out.println(s1.width);
		System.out.println(s1.height);
		
		
		
		Size s2 = new Size();
		s2.name = "키보드";
		s2.width = 50;
		s2.height = 30;
		
		System.out.println(s2.name);
		System.out.println(s2.width);
		System.out.println(s2.height);
		
		
		
		
		//요구사항3] 성적 처리, 국영수
		
		Score m1 = new Score();
		
		m1.name = "홍길동";
		m1.kor = 100;
		m1.eng = 90;
		m1.math = 80;

		
		Score m2 = new Score();
		
		m2.name = "아무개";
		m2.kor = 90;
		m2.eng = 80;
		m2.math = 90;
	
	
	
	
	
	
	
	
	}//main
}//class



//성적 처리

class Score {
	
	public String name;
	public int kor;
	public int eng;
	public int math;
	
}




//크기 저장
class Size {
	
	
	//
	public String name; //무엇의 크기인지 이름도 저장하자
	public int width;
	public int height;
	
}






//자바의 변수 종류
//1. 클래스 멤버 변수
//2. 지역 변수



//설계도
//클래스 선언하기 > 클래스 이름: 파스칼 표기법
class Point {
	
	//멤버 선언하기(변수, 메소드) > 클래스 멤버 변수
	public int x;
	public int y;
	

}


//클래스 + 객체(인스턴스)
//- 붕어빵 + 붕어빵틀

