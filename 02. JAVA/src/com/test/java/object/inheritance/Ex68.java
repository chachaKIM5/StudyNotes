package com.test.java.obj.inheritance;

public class Ex68 {

	public static void main(String[] args) {
		
		//Ex68
		
		//상속, this, super
		CupChild c = new CupChild();
		
		//외부
		
		c.b = 10;
		c.bbb();
		c.test();
		c.call();
	}
}


class CupParent {
	
	
	//접근지정자도 변함없이 그대로 상속된다
	private int a;
	public int b;
	
	private void aaa() {
		
	}
	
	public void bbb() {
		
	}
	
	public void test() {
		System.out.println("부모 메소드");
	}
	
	
}


class CupChild extends CupParent {


	//같은 클래스 내부에서는 접근 지정자가 동작하지 않는다
	//같은 클래스 안에서 전부 같은 식구다 > 접근 가능!
	private int c;
	public void ccc() {
		
		//부모가 물려준 private 멤버는 안 보인다!
		//System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//aaa();
		bbb();
		
	}
	
	@Override
	public void test() {
		System.out.println("재정의 자식 메소드");
	}
	
	public void call() {
		//자식 메소드 test 호출
		this.test();
		
		//그런 경우가 생기면 안 좋지만..(설계 문제 있을 가능성)
		//부모가 물려준 test()를 호출하고 싶은 경우는?
		
		
		//부모 메소드 test 호출
		super.test();
		
		//객체 접근 연산자
		//1. this > 나, 현재 객체
		//2. super > 부모 객체
	}
	
}