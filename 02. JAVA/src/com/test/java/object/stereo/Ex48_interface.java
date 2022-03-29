package com.test.java.obj.stereo;

public class Ex48_interface {

	public static void main(String[] args) {
		
	//"com.test.java.obj.stereo" > "Ex48_interface.java"
	
	/*
	 
	 	Stereo Type
	 	- 추상적인 자료형
	 	- 인터페이스, 추상클래스 > 클래스의 일종
	 	
	 	
	 	
	 	인터페이스, interface
	 	
	  
	 */
		
		
		G304 m1 = new G304();
		m1.click();
		m1.click();
		m1.click();
		
		//새 마우스
		G102 m2 = new G102();
		m2.click();
		m2.click();
		m2.click();
		
		
		
		
		//1. 인터페이스는 자료형이다
		//2. 인터페이스는 객체를 만들 수 없다
		//  > 추상 멤버(추상 메소드)를 가지고 있기 때문에 실체화할 수 없다.
		
		//Mouse m1 = new Mouse();
		//m1.test(); //이것 때문에 객체를 만들 수가 없다. (*****)
		
		
		
		
	} //main
} //Ex48

//서로 비슷한 부류의 객체들의 사용법을 물리적으로 통일시키는 방법
// > 인터페이스
// > == 제품의 "규격" 역할

//인터페이스 선언
interface Mouse {

	//인터페이스 멤버 선언
	//- 추상 메소드를 멤버로 가진다. (**********)
	//- 멤버 변수, 멤버 메소드는 가질 수 없다.
	
	//추상 메소드 선언(인터페이스 멤버)
	void test();
	
	void click();

}

//클래스 선언

//The type G304 must implement the inherited abstract method Mouse.test()
//하지만 일반 클래스는 추상 메소드를 가질 수 없다
class G304 implements Mouse {
	
	//클래스 멤버 선언
	private String type;
	private String color;
	private int dpi;
	
	@Override
	public void click() {	
		System.out.println("테스트를 진행합니다.");
	}

	
	//부모 클래스가 물려준 추상 메소드와 똑같은 메소드를 만들지만, 바디를 추가
	//*** 인터페이스는 자식 클래스에 강제로(***) 어떤 메소드를 만들도록 한다.
	@Override
	public void test() {	
		//내 맘대로 Override~!
	}
	
}


class G102 implements Mouse {
	private String color;
	private int price;
	private int buttons;
	
	public void click() {
		
	}
	
	public void test() {
		
	}
}


//A와 B, A와 C는 연관관계
//다른 클래스를 멤버로 갖는다
class AAA {
	private BBB b;
	private int num;
	private CCC[] list;
}

class BBB {
	 
}


class CCC {
	
}


//D와 E는 의존 관계
class DDD {
	public void test() {
		EEE e = new EEE();
	}
}

class EEE {
	
}