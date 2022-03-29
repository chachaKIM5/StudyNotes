package com.test.java.obj.stereo;

public class Ex50_abstract {

	public static void main(String[] args) {
		
		//Ex50_abstract.java
		
		/*
		 
		 특징
		 
		 1. 클래스
		 	- 실체화를 한다 > 즉 객체를 만든다.
		 	- 구현된 멤버를 가진다. > 멤버 변수, 멤버 메소드({body})
		 
		 2. 인터페이스
		 	- 실체화 불가능 > 객체를 만들 수 없다.
		 	- 추상 멤버를 가진다. > 추상 메소드
		 	- 자바에 한해서는 다른 것도 넣을 수 있지만... 보통 추상 메소드만
		 	- 클래스의 부모 역할 > 표준화(사용법 강제 통일) + 자격 부여
		 
		 3. 추상 클래스
		  	- 클래스와 인터페이스의 중간
		  	- 실체화가 불가능 > 객체를 만들 수 없다
		  	- 구현된 멤버를 가진다 > 멤버 변수, 멤버 메소드({body})
		  	- 추상 멤버를 가진다 > 추상 메소드
		  
		  
		  사용 빈도: 인터페이스(*****) >>>>> 추상 클래스 (다루기 힘들고 제약이 많아진다)
		 */
		
		//추상 클래스 -> 객체 만들 수 없다
		//Keyboard k1 = new Keyboard();
		
		K8 k = new K8();
		k.color = "white";  	//구현 멤버 사용
		k.info();   			//구현 멤버 사용
		k.charge(); 			//추상 멤버 구현
		
	} //main
} //Ex50


//추상 클래스

abstract class Keyboard {
	
	//구현 멤버
	private int price;
	public String color;
	
	public void info() {
		System.out.println(this.color);
	}
	
	
	//추상 멤버
	//인터페이스에서 생략됐던 public abstract 꼭 적어야 한다
	public abstract void charge();
}



class K8 extends Keyboard {
	@Override
	public void charge() {	
		System.out.println("충전합니다.");
	}	
}