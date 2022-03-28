package com.test.java;

public class Item46 {

	public static void main(String[] args) {
		
		//[SUMMARY] 오버라이드 Override, 오버라이딩 Overriding, 재정의 (2022. 3. 28. 오후 10:54:36)
		
		/*
		 
		 자식 클래스가 상속받은 부모 클래스의 메소드를 그대로 사용하고 싶지 않을 때
		 > 메소드를 업그레이드해 재정의
		 > 같은 메소드 시그너처 사용, 내용을 바꾼다
		 
		 */
		
		Parent p1 = new Parent();
		p1.name = "김아빠";
		p1.info();
		
		Child c1 = new Child();
		c1.name = "김아들";
		c1.info();
	}
}


class Parent {
	public String name;

	public void info() {
		System.out.printf("안녕하세요, 저는 %s입니다.\n", this.name);
	}
}


class Child extends Parent {
	
	public void info() {
		System.out.printf("안녕하십니까? 저는 아들 %s입니다.\n", this.name);
	}
} 