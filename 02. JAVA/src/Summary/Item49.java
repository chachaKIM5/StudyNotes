package com.test.java;

public class Item49 {
	
	public static void main(String[] args) {
	
		//[SUMMARY] 형변환, 업캐스팅(Up Casting), 다운캐스팅(Down Casting) (2022. 3. 29. 오후 10:27:20)

		/*
		
		 1. 업캐스팅, Up Casting
		 	- 부모 클래스 = 자식 클래스
		 	- 암시적인 형변환
		 	- 자식 클래스 -> 부모 클래스
		 	- 100% 가능
		 	
		 
		 	
		 2. 다운 캐스팅, Down Casting
		 	- 자식 클래스 = 부모 클래스
		 	- 명시적인 형변환
		 	- 부모 클래스 -> 자식 클래스
		 	- 100% 불가능
		 	- 내부 조작을 거쳐 가능
		 
		 */
	
		
		//1. 업캐스팅 예시
		ParentItem49 p1;
		ChildItem49 c1 = new ChildItem49();
		
		p1 = c1;
		
		p1.a = 10;
		p1.b = 20;
		
		System.out.println(p1.a);
		System.out.println(p1.b);
		
		
		//2. 다운캐스팅 예시
		p1.sayHi();							//업캐스팅으로 복사된 자식 클래스의 sayHi 출력
		if (p1 instanceof ChildItem49) {	
			((ChildItem49)p1).introduce();	//다운캐스팅으로 자식 클래스의 introduce 출력
		}
		
	
	}
}

class ParentItem49 {
	public int a;
	public int b;
	
	public void sayHi() {
		
	}
}

class ChildItem49 extends ParentItem49 {
	public int c;
	public int d;
	
	public void sayHi () {
		System.out.println("안녕하세요?");
	}
	
	public void introduce() {
		System.out.println("저는 자식 클래스입니다.");
	}
}