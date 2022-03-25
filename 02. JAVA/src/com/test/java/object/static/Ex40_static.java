package com.test.java.obj.staticmember;

public class Ex40_static {

	public static void main(String[] args) {
		
		//Ex40_static.java
		//요구사항]
		//1. 펜을 생산하시오
		//2. 생산된 팬의 개수를 세시오.
		
		
		//Case 1. 첫 번째 방법
		// - Pen과 count 간의 관계가 약하다 > 가독성 낮음 (count라는 이름도 Pen과 아무런 상관 X)
		// - 오차 발생(count++ 누락)
//		int count = 0;
//		
//		Pen p1 = new Pen("MonAmi", "Black");
//		count++;
//		
//		Pen p2 = new Pen("MonAmi", "Black");
//		count++;
//		
//		Pen p3 = new Pen("MonAmi", "Black");
//		count++;
//		
//		System.out.println("볼펜 개수: " + count);

		
		
		//Case 2. 두 번째 방법
		// - count 변수와 Pen의 관계를 강하게 연결해 주기 > 결합
		// - class Pen 안에 count 변수 만들기
		// - 차라리 Case1이 더 나은 방법
		
//		Pen p1 = new Pen("MonAmi", "Black");
//		p1.count++;
//
//		Pen p2 = new Pen("MonAmi", "Black");
//		p1.count++;
//		
//		Pen p3 = new Pen("MonAmi", "Black");
//		p1.count++;
//		
//		System.out.println("볼펜 개수: " + p1.count);
//		//p1이라는 객체(개인)가 모든 펜들의 개수를 세는 공통적인 값을 대표로 저장?
//		System.out.println("볼펜 개수: " + p2.count);
//		System.out.println("볼펜 개수: " + p3.count);
		
		
		
		//Case 3. 세 번째 방법
		//- Pen과 count 변수 간의 관계가 명확
		//- 소재 분명 > 여러곳 > 유일!!! > 변수 딱 1개
		
//		Pen p1 = new Pen("MonAmi", "Black");
//		Pen.count++;
//		
//		Pen p2 = new Pen("MonAmi", "Black");
//		Pen.count++;
//		
//		Pen p3 = new Pen("MonAmi", "Black");
//		Pen.count++;
//		
//		System.out.println("볼펜 개수: " + Pen.count);
		
		
		
		//Case 3. 세 번째 방법
		//static 정적 변수와 생성자를 모두 활용, 펜이 만들어질 때마다 Pen.count++ 되도록 하기
		// 가장 이상적이다!
		
		Pen p1 = new Pen("MonAmi", "Black");		
		Pen p2 = new Pen("MonAmi", "Black");
		Pen p3 = new Pen("MonAmi", "Black");
		
		System.out.println("볼펜 개수: " + Pen.count);
		
	}//main
}//Ex40


//class Pen {
//	
//	private String model;
//	private String color;
//	public int count = 0;
//	
//	public Pen(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
//
//	public String dump() {
//		return String.format("{ model: %s, color: %s }"
//								, this.model
//								, this.color);
//	}
//
//
//
//}


class Pen {
	
	private String model;
	private String color;
	public static int count = 0; //공용 데이터
	
	public Pen(String model, String color) {
		this.model = model;
		this.color = color;
		Pen.count++;			//Pen을 만들 때마다 호출되는 메소드 생성자..!
								//호출할 때마다 펜 개수를 카운트할 수 있다
	}
	
	public String dump() {
		return String.format("{ model: %s, color: %s }"
				, this.model
				, this.color);
	}
	
	
	
}

