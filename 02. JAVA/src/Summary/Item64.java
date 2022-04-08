package com.test.java;

public class Item64 {

	public static void main(String[] args) {
		
		//[SUMMARY] 익명 객체 (2022. 4. 8. 오후 10:31:02)
		
		/*
		 
		 인터페이스를 구현한 클래스의 객체 생성
		 1. 본인 타입으로 참조 변수 만들기
		 2. 부모 타입(인터페이스)으로 참조 변수 만들기
		 3. 익명 객체 만들기		 
		 	- 익명 객체는 자신만의 멤버를 만들 수 없다
			> 부모 인터페이스를 통해 호출 불가능, 다운캐스팅 불가능(타입의 이름이 없다!)
		
			b2 vs b3, b2는 ((BBB)b2).bbb(); 등으로 사용 가능하지만, b3는 사용 불가능
			- *** 모든 코드를 통틀어 단 1개의 객체가 필요한 경우 > 익명 클래스 사용
		 
		 */
		
		//1
		BBBBB b1 = new BBBBB();
		b1.aaa();
		b1.bbb();
		
		//2
		AAAAA b2 = new BBBBB();
		b2.aaa();
		((BBBBB)b2).bbb(); //고유 멤버 접근이 필요하면 다운캐스팅해서 사용
		
		//3
		AAAAA b3 = new AAAAA() {
			public void aaa() {
				System.out.println("추상 메소드 구현");
			}
		};
		
	}
}

interface AAAAA {
	void aaa();
	
}

class BBBBB implements AAAAA {

	@Override
	public void aaa() {
		System.out.println("추상 메소드 구현");
	}
	
	public void bbb() {
		System.out.println("자신만의 메소드 구현");
	}
	
	
}